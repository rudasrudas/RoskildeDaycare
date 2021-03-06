package build.Model.lists;

import build.Model.data.BankInfo;
import build.Model.data.Group;

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
            statement.executeUpdate(sql1);

            for(Group g : groupList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.class (ClassName)" +
                                "VALUES ('%s')",
                        g.getGroupName());

                int id = statement.executeUpdate(sql2, Statement.RETURN_GENERATED_KEYS);
                g.setId(id);
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

    public void add(Group group){
        groupList.add(group);
    }
    public void remove(Group group){ groupList.remove(group); }

    public static int locateID(Statement statement, Group group){
        if(group == null) return -1;

        String sql = String.format("SELECT * FROM roskildedaycare1.class WHERE ClassName = '%s'",
                group.getGroupName());
        try{
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next())return rs.getInt("PK_Class");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return -1;
    }

    public String toString(){
        String result = "";

        for(int i = 0; i < groupList.size(); i++){
            result += i + ". " + groupList.get(i).toString() + "\n";
        }

        return result;
    }

    public Group select(Scanner scanner){

        int index;
        String input;

        do {
            try {
                System.out.println("Please select a group: ");
                System.out.println(toString());
                input = scanner.nextLine();

                if(input.equals("")) return null;

                index = Integer.valueOf(input);
            }
            catch (Exception e){
                System.out.println("Input is incorrect. Try again.");
                index = -1;
            }
        }
        while(index < 0 || index >= groupList.size());

        return groupList.get(index);
    }
}
