package com.common.entity;

import lombok.Data;

@Data
public class Result {

    protected Integer code;

    protected String zhDesc;

    protected String enDesc;

    protected Object data;
}
