package Model;

public class UserAccount {
    private String username;
    private String password;
    private String authorisation;

    public UserAccount(String username, String password, String authorisation) {
        this.username = username;
        this.password = password;
        this.authorisation = authorisation;
    }

    public String toString(){
        return "User: " + username + " (" + authorisation + ")";
    }
}
