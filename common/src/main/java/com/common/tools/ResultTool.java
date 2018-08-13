package com.common.tools;

import com.common.entity.ListResult;
import com.common.entity.Result;
import com.common.enums.StateEnum;

import java.util.List;

public class ResultTool {

    /**
     * 成功不返回任何数据
     * @return
     */
    public static Result success() {
        return customResp(StateEnum.OK,null);
    }

    /**
     * 成功返回map数据
     * @return
     */
    public static Result successWithMap(Object map) {
        return customResp(StateEnum.OK,map);
    }
    /**
     * 成功返回list数据
     * @return
     */
    public static Result successWithList(List<?> list) {
        ListResult lResult = new ListResult();
        lResult.setTotalRow(list.size());
        lResult.setList(list);
        return customResp(StateEnum.OK,lResult);
    }

    /**
     * 失败统一返回数据
     */
    public static Result failed() {
        return customResp(StateEnum.FAIL,null);
    }

    /**
     * 失败返回定义好的数据
     */
    public static Result failed(StateEnum stateEnum) {
        return customResp(stateEnum,null);
    }

    /**
     * 失败统一返回数据加自定义描述
     */
    public static Result failedWithDesc(Integer code,String zhDesc,String enDesc) {
        Result result = new Result();
        result.setCode(code);
        result.setZhDesc(zhDesc);
        result.setEnDesc(enDesc);
        return result;
    }

    /**
     * 自定义返回的数据
     */
    private static Result customResp(StateEnum stateEnum,Object data){
        Result result = new Result();
        result.setCode(stateEnum.getCode());
        result.setZhDesc(stateEnum.getZhDesc());
        result.setEnDesc(stateEnum.getEnDesc());
        result.setData(data);
        return result;
    }

}
