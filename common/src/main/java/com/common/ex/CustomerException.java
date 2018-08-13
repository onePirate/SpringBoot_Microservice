package com.common.ex;

import com.common.enums.StateEnum;
import lombok.Setter;

/**
 * @Author: gwx556610
 * @Date: 17:16 2018/8/8
 * @Desc:
 */
@Setter
public class CustomerException extends RuntimeException{

    private Integer code;

    public CustomerException(Integer errorCode, String message)
    {
        super(message);
        this.setCode(errorCode);
    }

    public CustomerException(StateEnum stateEnum)
    {
        super(stateEnum.getZhDesc());
        this.setCode(stateEnum.getCode());
    }
}
