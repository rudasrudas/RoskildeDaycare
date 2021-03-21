package Model.lists;

import Model.data.Child;
import Model.data.Group;
import Model.data.UserAccount;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserAccountList {
    private ArrayList<UserAccount> userAccountList;

    public UserAccountList(Statement statement){
        userAccountList = new ArrayList<>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.class";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                userAccountList.add(new UserAccount(rs.getInt("PK_UserAccount"),
                        rs.getString("Username"),
                        rs.getString("UserPassword"),
                        rs.getInt("Authorization")));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void saveToDatabase(Statement statement){
        try{
            String sql1 = "TRUNCATE TABLE roskildedaycare1.useraccount";
            statement.executeQuery(sql1);

            for(UserAccount u : userAccountList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.useraccount (PK_UserAccount, Username, UserPassword, Authorization)" +
                                "VALUES (%d, %s, %s, %s)",
                        u.getId(),
                        u.getUsername(),
                        u.getPassword(),
                        u.getAuthorisation());

                statement.executeQuery(sql2);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public UserAccount getUserAccount(int id){
        for(UserAccount u : userAccountList){
            if(u.getId() == id) return u;
        }

        return null;
    }

    public String toString(){
        String result = "";

        for (int i = 0; i < userAccountList.size(); i++) {
            result += i + ". " + userAccountList.get(i).toString();
        }
        return result;
    }
}
