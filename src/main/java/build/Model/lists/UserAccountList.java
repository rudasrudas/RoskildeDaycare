package build.Model.lists;

import build.Model.data.Teacher;
import build.Model.data.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserAccountList {
    private ArrayList<UserAccount> userAccountList;

    public UserAccountList(Statement statement){
        userAccountList = new ArrayList<>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.useraccount";
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
            statement.executeUpdate(sql1);

            for(UserAccount u : userAccountList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.useraccount (Username, UserPassword, Authorization)" +
                                "VALUES ('%s', '%s', '%s')",
                        u.getUsername(),
                        u.getPassword(),
                        u.getAuthorisation());

                statement.executeUpdate(sql2);
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

    public void add(UserAccount userAccount){
        userAccountList.add(userAccount);
    }
    public void remove(UserAccount userAccount){
        userAccountList.remove(userAccount);
    }

    public UserAccount findAccount(String username, String password){
        for(UserAccount u : userAccountList){
            if(u.isCorrectPassword(password) && u.getUsername().equals(username)){
                return u;
            }
        }

        return null;
    }

    public String toString(){
        String result = "";

        for (int i = 0; i < userAccountList.size(); i++) {
            result += i + ". " + userAccountList.get(i).toString() + "\n";
        }
        return result;
    }
}
