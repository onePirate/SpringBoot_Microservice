package com.common.enums;

/**
 * @Author: gwx556610
 * @Date: 17:13 2018/8/6
 * @Desc:
 */
public enum StateEnum {

    OK(200,"成功","success"),
    FAIL(500,"失败","failed"),
    REQ_HAS_ERR(506,"请求数据有误","request data has error!");

    StateEnum(Integer code, String zhDesc, String enDesc) {
        this.code = code;
        this.zhDesc = zhDesc;
        this.enDesc = enDesc;
    }

    /**
     * code
     */
    private Integer code;

    /**
     * 中文释义
     */
    private String zhDesc;

    /**
     * English Desc
     */
    private String enDesc;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getZhDesc() {
        return zhDesc;
    }

    public void setZhDesc(String zhDesc) {
        this.zhDesc = zhDesc;
    }

    public String getEnDesc() {
        return enDesc;
    }

    public void setEnDesc(String enDesc) {
        this.enDesc = enDesc;
    }
}
