package com.common.entity;

import lombok.Data;

/**
 * @Author: gaodw
 * @Date: 17:19 2018/8/8
 * @Desc: 如果是List则返回
 */
@Data
public class ListResult {

    //当前页
    protected Integer curPage;

    //总页数
    protected Integer totalPage;

    //总条数
    protected Integer totalRow;

    //列表
    protected Object list;

}
