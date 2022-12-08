package com.sporting.admin.dto.payment;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaymentInitial implements Serializable {
    private long id;
    private String paymentId;
    private String paymentAmount;
    private String type;
    private String active;
    private String paymentDate;
}
