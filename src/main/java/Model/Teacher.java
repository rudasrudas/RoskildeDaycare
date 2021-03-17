package Model;

public class Teacher {

    private String prefix;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    public Teacher(String prefix, String name, String surname, String phoneNumber, String email) {
        this.prefix = prefix;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString(){
        return prefix + " " +
                name + " " +
                surname + " " +
                phoneNumber + " " +
                email;
    }
}
