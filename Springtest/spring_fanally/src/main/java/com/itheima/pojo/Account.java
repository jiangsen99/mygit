package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.ws.Service;

/**
 * 包名:com.itheima.pojo
 * 程序猿:wushengdaozu
 * 日期: 2020--02--18    10:19:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
 private Integer id;
 private Service name;
 private Double momey;
}
