package models;

import java.util.Date;

public class Bill extends BaseModel {
    private Ticket ticket;
    private Date exitTime;
    private double amount;
    private Operator operator;
    private BillPaymentStatus billPaymentStatus;
}
