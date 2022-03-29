package com.zhy.market.domain;

import lombok.Data;

@Data
public class User {
    public Integer userid;
    public String useruuid;
    public String username;
    public String password;
    public Boolean gender;
    public String address;
    public String phonenumber;

}
