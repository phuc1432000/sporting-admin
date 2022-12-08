package com.sporting.admin.dto.account;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountInitial implements Serializable {
    private Long id;
    private String accountId;
    private String email;
    private String password;
    private String fullName;
    private String role;
    private String phone;
    private String address;
    private String active;
}
