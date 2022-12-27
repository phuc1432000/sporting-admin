package com.sporting.admin.service;

import com.sporting.admin.dto.orderDetail.OrderDetailDTO;
import com.sporting.admin.dto.orderDetail.OrderDetailInitial;

public interface OrderDetailService {
    OrderDetailDTO getAll();

    OrderDetailDTO getByUuid(String uuid);

    OrderDetailDTO performLock(String uuid);
    OrderDetailDTO create(OrderDetailInitial order);
    OrderDetailDTO delete(String uuid);
}
