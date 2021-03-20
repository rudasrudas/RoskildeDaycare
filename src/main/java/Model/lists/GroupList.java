package Model.lists;

import Model.data.Group;
import Model.data.UserAccount;

import java.sql.*;
import java.util.*;

public class GroupList {
    private ArrayList<Group> groupList;

    public GroupList(Statement statement){
        groupList = new ArrayList<Group>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.class";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                groupList.add(new Group(rs.getInt("PK_Class"),
                        rs.getString("ClassName")));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void saveToDatabase(Statement statement){
        try{
            String sql1 = "TRUNCATE TABLE roskildedaycare1.class";
            statement.executeQuery(sql1);

            for(Group g : groupList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.class (PK_Class, ClassName)" +
                                "VALUES (%d, %s)",
                        g.getId(),
                        g.getGroupName());

                statement.executeQuery(sql2);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Group getGroup(int id){
        for(Group g : groupList){
            if(g.getId() == id) return g;
        }

        return null;
    }

    public String toString(){
        String result = "";

        for(int i = 0; i < groupList.size(); i++){
            result += i + ". " + groupList.get(i).toString();
        }

        return result;
    }

    public Group selectGroup(Scanner scanner){

        int index;

        do {
            try {
                System.out.println("Please select a group: ");
                System.out.println(toString());
                index = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Input is incorrect. Try again.");
                index = -1;
            }
        }
        while(index >= 0 && index < groupList.size());

        return groupList.get(index);
    }
}
