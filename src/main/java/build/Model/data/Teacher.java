package build.Model.data;

public class Teacher {

    private int id;
    private String prefix;
    private String name;
    private String surname;
    private Group group;
    private String phoneNumber;
    private String email;
    private Address address;
    private BankInfo bankInfo;

    public Teacher(int id, String prefix, String name, String surname, Group group, String phoneNumber, String email, Address address, BankInfo bankInfo) {
        this.id = id;
        this.prefix = prefix;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Group getGroup() {
        return group;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public String toString(){
        return prefix + " " +
                name + " " +
                surname + " " +
                phoneNumber + " " +
                email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }
}