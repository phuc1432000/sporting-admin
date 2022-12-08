package com.sporting.admin.service;

import com.sporting.admin.dto.account.AccountDTO;
import com.sporting.admin.dto.account.AccountInitial;

public interface AccountService {

    /**
     * 账户
     *
     * @return CartDetailDTO
     */
    AccountDTO getAll();

    /**
     * 账户
     *
     * @param uuid
     * @return CartDetailDTO
     */
    AccountDTO getByUuid(String uuid);

    /**
     * 账户
     *
     * @param dto
     * @return CartDetailDTO
     */
    AccountDTO create(AccountInitial dto);

    /**
     * 账户
     *
     * @param dto
     * @return CartDetailDTO
     */
    AccountDTO update(AccountInitial dto);

    /**
     * 账户
     *
     * @param uuid
     * @return CartDetailDTO
     */
    AccountDTO delete(String uuid);

    /**
     * 账户
     *
     * @param uuid
     * @return CartDetailDTO
     */
    AccountDTO performLock(String uuid);

    /**
     * 账户
     *
     * @param dto
     * @return CartDetailDTO
     */
    AccountDTO login(AccountInitial dto);
}
