package build.Model.data;

import java.nio.charset.StandardCharsets;

import build.Controller.Controller;
import com.google.common.hash.Hashing;

public class UserAccount {
    private int id;
    private String username;
    private String password;
    private int authorisation;

    public UserAccount(int id, String username, String password, int authorisation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorisation = authorisation;
    }

    public String toString(){
        return "User: " + username + " (" + authorisation + ")";
    }

    public int getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAuthorisation() {
        return authorisation;
    }

    public boolean isCorrectPassword(String input) {
        String result = Controller.hash(input);

        return result.equals(password);
    }
}
