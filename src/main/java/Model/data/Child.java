package Model.data;

import Model.Model;

public class Child {
    private int id;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String sex;
    private String entryDate;
    private String activityStatus;
    private String paymentDate;
    private int paymentPeriod;
    private String paymentStatus;
    private Parent parent1;
    private Parent parent2;

    public Child(int id,
                 String name,
                 String surname,
                 String dateOfBirth,
                 String sex,
                 String entryDate,
                 String activityStatus,
                 String paymentDate,
                 int paymentPeriod,
                 String paymentStatus,
                 Parent parent1,
                 Parent parent2) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.entryDate = entryDate;
        this.activityStatus = activityStatus;
        this.paymentDate = paymentDate;
        this.paymentPeriod = paymentPeriod;
        this.paymentStatus = paymentStatus;
        this.parent1 = parent1;
        this.parent2 = parent2;
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
