package models;

import java.util.Date;

public class Payment extends BaseModel {
    private Bill bill;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Date time;
    private String referenceID;
}
