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
}