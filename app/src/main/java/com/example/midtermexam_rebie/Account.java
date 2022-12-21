package com.example.midtermexam_rebie;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {
    String accountNumber;
    String bankName;
    int balance;

    public Account(String accountNumber, String bankName, int balance) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
    }


    protected Account(Parcel in) {
        accountNumber = in.readString();
        bankName = in.readString();
        balance = in.readInt();
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public int getBalance() {
        return balance;
    }
    public void deposit(int amount){
        balance = balance + amount;
    }
    public void withdraw(int amount){
        if(balance >= amount){
            balance = balance-amount;
        }
    }
    @Override
    public String toString() {
        return "Account Number= " + accountNumber + "\n" +
                "Bank Name= " + bankName + "\n" +
                "Balance= " + balance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(accountNumber);
        parcel.writeString(bankName);
        parcel.writeInt(balance);
    }
}
