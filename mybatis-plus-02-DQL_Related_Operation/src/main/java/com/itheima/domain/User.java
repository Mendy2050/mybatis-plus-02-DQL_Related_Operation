package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Mendy
 * @create 2023-07-04 19:31
 */
@Data
@TableName("tbl_user")
public class User {
    private Long id;
    private String name;

    @TableField(value = "pwd", select = false)
    private String password;

    private Integer age;
    private String tel;

    @TableField(exist = false)
    private Integer online;
}

