package com.common.entity;

import lombok.Data;

@Data
public class BasePojo {

    /**
     * 开始日期
     */
    protected String startDate;

    /**
     * 结束日期
     */
    protected String endDate;

    /**
     * 页码下标
     */
    protected Integer pageIndex;

    /**
     * 开始下标
     */
    protected Integer pageStart;

    /**
     * 页尺寸
     */
    protected Integer pageSize;
}
