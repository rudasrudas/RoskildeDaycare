package Model.lists;

import Model.data.Group;

import java.sql.*;
import java.util.ArrayList;

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
}
