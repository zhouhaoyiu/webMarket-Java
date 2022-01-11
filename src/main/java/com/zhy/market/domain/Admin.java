package com.zhy.market.domain;

import lombok.Data;

@Data
public class Admin {
    public Integer adminId;
    public String userName;
    public String passWord;
    public String adminUUid;
    public String phoneNumber;
    public String emailAddress;
    public Integer adminRole;
    public String pin;
}
