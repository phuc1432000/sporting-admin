package com.sporting.admin.service.impl;

import com.google.gson.Gson;
import com.sporting.admin.consts.URLConstants;
import com.sporting.admin.dto.account.AccountDTO;
import com.sporting.admin.dto.account.AccountInitial;
import com.sporting.admin.dto.account.AccountRequest;
import com.sporting.admin.service.AccountService;
import com.sporting.admin.utils.HttpOkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Value("${admin.host.url}")
    String url;

    @Override
    public AccountDTO login(AccountInitial accountInitial) {
        String getUrl = url + URLConstants.ACCOUNT_VALIDATE_LOGIN;
        Gson gson = new Gson();
        String json = gson.toJson(accountInitial);
        AccountDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", AccountDTO.class);
        return dto;
    }

    @Override
    public AccountDTO getAll() {
        String getUrl = url + URLConstants.ACCOUNT_GET_ALL;
        AccountDTO dto = HttpOkUtils.callApiByGet(getUrl, "", AccountDTO.class);
        return dto;
    }

    @Override
    public AccountDTO getByUuid(String accountId) {
        String getUrl = url + URLConstants.ACCOUNT_GET_UUID;
        AccountRequest request = new AccountRequest();
        request.setAccountId(accountId);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        AccountDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", AccountDTO.class);
        return dto;
    }

    @Override
    public AccountDTO update(AccountInitial accountInitial) {
        String getUrl = url + URLConstants.ACCOUNT_UPDATE;
        Gson gson = new Gson();
        String json = gson.toJson(accountInitial);
        AccountDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", AccountDTO.class);
        return dto;
    }

    @Override
    public AccountDTO create(AccountInitial account) {
        String getUrl = url + URLConstants.ACCOUNT_CREATE;
        account.setAccountId(UUID.randomUUID().toString());
        account.setActive("01");
        Gson gson = new Gson();
        String json = gson.toJson(account);
        AccountDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", AccountDTO.class);
        return dto;
    }

    @Override
    public AccountDTO delete(String accountId) {
        String getUrl = url + URLConstants.ACCOUNT_DELETE;
        AccountRequest request = new AccountRequest();
        request.setAccountId(accountId);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        AccountDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", AccountDTO.class);
        return dto;
    }

    @Override
    public AccountDTO performLock(String accountId) {
        String getUrl = url + URLConstants.ACCOUNT_PERFORM_LOCK;
        AccountRequest request = new AccountRequest();
        request.setAccountId(accountId);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        AccountDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", AccountDTO.class);
        return dto;
    }
}
