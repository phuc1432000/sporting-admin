package com.sporting.admin.service;

import com.sporting.admin.dto.payment.PaymentDTO;

public interface PaymentService {
    PaymentDTO getAll();

    PaymentDTO getByUuid(String uuid);

    PaymentDTO delete(String uuid);

    PaymentDTO performLock(String uuid);
}
