package Model.data;

import Model.Model;

public class BankInfo {
    private int id;
    private String bankName;
    private String accountName;
    private String accountSurname;
    private int accountNumber;
    private int regNumber;
    private String email;

    public BankInfo(int id,
                    String bankName,
                    String accountName,
                    String accountSurname,
                    int accountNumber,
                    int regNumber,
                    String email) {
        this.id = id;
        this.bankName = bankName;
        this.accountName = accountName;
        this.accountSurname = accountSurname;
        this.accountNumber = accountNumber;
        this.regNumber = regNumber;
        this.email = email;
    }

    public String toString(){
        return bankName + " " +
                accountName + " " +
                accountSurname + " " +
                accountNumber + " " +
                regNumber + " " +
                email;
    }
}
