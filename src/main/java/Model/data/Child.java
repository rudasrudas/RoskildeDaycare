package Model.data;

import Model.Model;

public class Child {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String sex;
    private String entryDate;
    private String activityStatus;
    private String paymentDate;
    private int paymentPeriod;
    private String paymentStatus;

    public Child(String name, String surname, String dateOfBirth, String sex, String entryDate, String activityStatus, String paymentDate, int paymentPeriod, String paymentStatus) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.entryDate = entryDate;
        this.activityStatus = activityStatus;
        this.paymentDate = paymentDate;
        this.paymentPeriod = paymentPeriod;
        this.paymentStatus = paymentStatus;
    }

    public String toString(){
        return name + ". " +
                surname + " " +
                dateOfBirth + " " +
                sex + " " +
                entryDate + " " +
                activityStatus + " " +
                paymentDate + " " +
                paymentPeriod + " " +
                paymentStatus;
    }

}
