package com.sporting.admin.dto.account;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AccountDTO implements Serializable {
    private String message;
    private String error_code;
    private List<AccountInitial> list;
    private AccountInitial data;
}
