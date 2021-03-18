package Model.data;

public class UserAccount {
    private int id;
    private String username;
    private String password;
    private String authorisation;

    public UserAccount(int id, String username, String password, String authorisation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorisation = authorisation;
    }

    public String toString(){
        return "User: " + username + " (" + authorisation + ")";
    }
}
