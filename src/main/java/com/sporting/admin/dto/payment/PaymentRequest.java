package com.sporting.admin.dto.payment;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaymentRequest implements Serializable {
    private String paymentId;
}
