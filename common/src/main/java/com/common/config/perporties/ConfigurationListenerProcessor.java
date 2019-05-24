package com.common.config.perporties;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
/**
 * @author gaodw
 * @createTime 2019-05-24 22:47
 * @description
 */
@Component
public class ConfigurationListenerProcessor implements ApplicationContextAware, InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(ConfigurationListenerProcessor.class);
    private ApplicationContext applicationContext;
    private String regEx = "\\%\\{[\\w\\(\\)\\.\\']+\\}";
    private Pattern pattern;

    public ConfigurationListenerProcessor() {
        this.pattern = Pattern.compile(this.regEx);
    }

    public void setCenterValue(Object bean) {
        Field[] var2 = bean.getClass().getDeclaredFields();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Field field = var2[var4];
            field.setAccessible(true);

            String filedValue;
            try {
                filedValue = String.valueOf(field.get(bean));
            } catch (IllegalAccessException var11) {
                var11.printStackTrace();
                log.error("Get filed [{}]'s value failed.", field.getName());
                continue;
            }

            Matcher matcher = this.pattern.matcher(filedValue);
            if (matcher.find()) {
                try {
                    String configEL = matcher.group();
                    Object centerValue = this.getCenterValue(configEL);
                    field.set(bean, convert(filedValue.replaceAll(this.regEx, String.valueOf(centerValue)), filedValue.getClass()));
                } catch (Exception var10) {
                    var10.printStackTrace();
                    log.error("Get center configuration's value of filed [{}] failed, filed value: {}", field.getName(), filedValue);
                }
            }
        }

    }

    public void afterPropertiesSet() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Object getCenterValue(String configEL) throws IllegalAccessException, InvocationTargetException {
        String configBeanName = configEL.substring(2, configEL.indexOf("."));
        String configMethodName = configEL.substring(configEL.indexOf(".") + 1, configEL.indexOf("("));
        String configArg = configEL.split("'")[1];
        Object configBean = this.applicationContext.getBean(configBeanName);
        Object centerValue = null;
        Method[] var7 = configBean.getClass().getMethods();
        int var8 = var7.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            Method method = var7[var9];
            if (configMethodName.equals(method.getName())) {
                centerValue = method.invoke(configBean, configArg);
                break;
            }
        }

        return centerValue;
    }

    public static <T> T convert(Object obj, Class<T> type) {
        T result = null;
        if (obj != null && !StringUtils.isEmpty(obj.toString())) {
            if (!type.equals(Integer.class) && !type.equals(Integer.TYPE)) {
                if (!type.equals(Long.class) && !type.equals(Long.TYPE)) {
                    if (!type.equals(Boolean.class) && !type.equals(Boolean.TYPE)) {
                        if (!type.equals(Short.class) && !type.equals(Short.TYPE)) {
                            if (!type.equals(Float.class) && !type.equals(Float.TYPE)) {
                                if (!type.equals(Double.class) && !type.equals(Double.TYPE)) {
                                    if (!type.equals(Byte.class) && !type.equals(Byte.TYPE)) {
                                        if (!type.equals(Character.class) && !type.equals(Character.TYPE)) {
                                            if (type.equals(String.class)) {
                                                result = (T) obj;
                                            }
                                        } else {
                                            result = (T)new Character(obj.toString().charAt(0));
                                        }
                                    } else {
                                        result = (T)new Byte(obj.toString());
                                    }
                                } else {
                                    result = (T)new Double(obj.toString());
                                }
                            } else {
                                result = (T)new Float(obj.toString());
                            }
                        } else {
                            result = (T)new Short(obj.toString());
                        }
                    } else {
                        result = (T)new Boolean(obj.toString());
                    }
                } else {
                    result = (T)new Long(obj.toString());
                }
            } else {
                result = (T)new Integer(obj.toString());
            }
        } else {
            result = null;
        }

        return result;
    }
}
