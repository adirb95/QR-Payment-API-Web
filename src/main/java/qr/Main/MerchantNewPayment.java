package qr.Main;

import org.springframework.context.annotation.Primary;

public class MerchantNewPayment {
    int transactionID;
    String merchantName;
    double transactionAmount;
    String transactionCurrency;
    private int accountNumber;
    private int branchNumber;
    private int bankID;
}
