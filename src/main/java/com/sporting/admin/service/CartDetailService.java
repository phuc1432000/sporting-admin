package com.sporting.admin.service;

import com.sporting.admin.dto.cartDetail.CartDetailDTO;

public interface CartDetailService {
    CartDetailDTO getAll();

    CartDetailDTO getByUuid(String uuid);

    CartDetailDTO performLock(String uuid);
}
