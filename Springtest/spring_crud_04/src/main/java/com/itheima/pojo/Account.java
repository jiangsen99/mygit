package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 包名:com.itheima.pojo
 * 作者:Leevi
 * 日期2020-02-15  10:31
 */
@Data
@AllArgsConstructor//有全参构造函数，那么就没有了无参构造
@NoArgsConstructor//无参构造
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
}
