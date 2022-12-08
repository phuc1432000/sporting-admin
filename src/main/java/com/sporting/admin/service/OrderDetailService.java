package com.sporting.admin.service;

import com.sporting.admin.dto.orderDetail.OrderDetailDTO;

public interface OrderDetailService {
    OrderDetailDTO getAll();

    OrderDetailDTO getByUuid(String uuid);

    OrderDetailDTO performLock(String uuid);
}
