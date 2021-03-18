package Model.data;

public class Parent {
    private int id;
    private String prefix;
    private String name;
    private String surname;
    private String relationship;
    private String phoneNumber;
    private String email;

    public Parent(int id,
                  String prefix,
                  String name,
                  String surname,
                  String relationship,
                  String phoneNumber,
                  String email) {
        this.id = id;
        this.prefix = prefix;
        this.name = name;
        this.surname = surname;
        this.relationship = relationship;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString(){
        return prefix + ". " +
                name + " " +
                surname + " (" +
                relationship + ") " +
                phoneNumber + " " +
                email;
    }
}
