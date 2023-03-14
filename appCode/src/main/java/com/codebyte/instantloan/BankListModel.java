package com.codebyte.instantloan;

public class BankListModel {
    String BankName;
    String balance;
    String customer;
    String mini;

    public BankListModel(String str, String str2, String str3, String str4) {
        this.BankName = str;
        this.balance = str2;
        this.mini = str3;
        this.customer = str4;
    }

    public String getBankName() {
        return this.BankName;
    }


    public String getBalance() {
        return this.balance;
    }


    public String getMini() {
        return this.mini;
    }


    public String getCustomer() {
        return this.customer;
    }

}
