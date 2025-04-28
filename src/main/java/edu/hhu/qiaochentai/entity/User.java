package edu.hhu.qiaochentai.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String nick_name;
    private String account;
    private String password;
    private String gender;
    private String birthday;
    private String phone ;
    private String email;
    private String head_pic;
    private String description;
    private String birthplace;
}
