package com.sporting.admin.dto.payment;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PaymentDTO implements Serializable {
    private String message;
    private String error_code;
    private List<PaymentInitial> list;
    private PaymentInitial data;
}
