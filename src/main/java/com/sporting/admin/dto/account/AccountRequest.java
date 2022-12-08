package com.sporting.admin.dto.account;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountRequest implements Serializable {
    private String accountId;
    private String username;
    private String password;
}
