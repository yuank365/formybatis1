package com.yyt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName mapper
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private static final long serialVersionUID = 1L;

}