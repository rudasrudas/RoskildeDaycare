package Model.lists;

import Model.data.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChildList {
    private ArrayList<Child> childList;

    public ChildList(Statement statement, GroupList groupList, ParentList parentList){
        childList = new ArrayList<>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.child";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

                int GroupID = rs.getInt("FK_Group");
                int Parent1ID = rs.getInt("FK_Parent1");
                int Parent2ID = rs.getInt("FK_Parent2");

                childList.add(new Child(rs.getInt("PK_Child"),
                rs.getString("ChildName"),
                rs.getString("ChildSurname"),
                rs.getString("DateOfBirth"),
                rs.getString("Sex"),
                rs.getString("EntryDate"),
                groupList.getGroup(GroupID),
                rs.getString("ActivityStatus"),
                rs.getString("PaymentDate"),
                rs.getInt("PaymentPeriod"),
                rs.getString("PaymentStatus"),
                parentList.getParent(Parent1ID),
                parentList.getParent(Parent2ID)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    private ArrayList<Child> waitingList;

    public ChildList(Statement statement, ParentList parentList){
        waitingList = new ArrayList<>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.waitinglist";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){

                int Parent1ID = rs.getInt("FK_Parent1");
                int Parent2ID = rs.getInt("FK_Parent2");

                waitingList.add(new Child(rs.getInt("PK_WaitingList"),
                        rs.getString("ChildName"),
                        rs.getString("ChildSurname"),
                        rs.getString("DateOfBirth"),
                        rs.getString("Sex"),
                        rs.getString("JoinDate"),
                        null,
                        null,
                        null,
                        0,
                        null,
                        parentList.getParent(Parent1ID),
                        parentList.getParent(Parent2ID)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Child getChild(int id){
        for(Child c : childList){
            if(c.getId() == id) return c;
        }

        return null;
    }

    public String toString(){
        String result = "";

        for(int i = 0; i < childList.size(); i++){
            result += i + ". " + childList.get(i).toString();
        }

        return result;
    }
}
