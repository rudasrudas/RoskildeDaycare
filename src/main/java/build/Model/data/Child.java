package build.Model.data;

public class Child {
    private int id;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String sex;
    private String entryDate;
    private Group group;
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
                 Group group,
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
        this.group = group;
        this.activityStatus = activityStatus;
        this.paymentDate = paymentDate;
        this.paymentPeriod = paymentPeriod;
        this.paymentStatus = paymentStatus;
        this.parent1 = parent1;
        this.parent2 = parent2;
    }

    public String toString(){
        return name + " " +
                surname + " " +
                dateOfBirth + " " +
                sex + " " +
                entryDate + " " +
                activityStatus + " " +
                paymentDate + " " +
                paymentPeriod + " " +
                paymentStatus;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public Group getGroup() {
        return group;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public int getPaymentPeriod() {
        return paymentPeriod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public Parent getParent1() {
        return parent1;
    }

    public Parent getParent2() {
        return parent2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentPeriod(int paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setParent1(Parent parent1) {
        this.parent1 = parent1;
    }

    public void setParent2(Parent parent2) {
        this.parent2 = parent2;
    }
}
