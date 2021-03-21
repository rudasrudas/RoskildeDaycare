package build.Model.data;

public class BankInfo {
    private int id;
    private String bankName;
    private String accountName;
    private String accountSurname;
    private int accountNumber;
    private int regNumber;
    private int kontoNumber;

    public BankInfo(int id,
                    String bankName,
                    String accountName,
                    String accountSurname,
                    int accountNumber,
                    int regNumber,
                    int kontoNumber) {
        this.id = id;
        this.bankName = bankName;
        this.accountName = accountName;
        this.accountSurname = accountSurname;
        this.accountNumber = accountNumber;
        this.regNumber = regNumber;
        this.kontoNumber = kontoNumber;
    }

    public int getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountSurname() {
        return accountSurname;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public int getKontoNumber() {
        return kontoNumber;
    }

    public String toString(){
        return bankName + " " +
                accountName + " " +
                accountSurname + " " +
                accountNumber + " " +
                regNumber + " " +
                kontoNumber;
    }
}
