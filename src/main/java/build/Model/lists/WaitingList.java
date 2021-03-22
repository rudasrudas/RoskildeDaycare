package build.Model.lists;

import build.Model.data.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WaitingList {
    private ArrayList<Child> waitingList;

    public WaitingList(Statement statement, ParentList parentList){
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

    public void saveToDatabase(Statement statement){
        try{
            String sql1 = "TRUNCATE TABLE roskildedaycare1.waitinglist";
            statement.executeQuery(sql1);

            for(Child c : waitingList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.waitinglist (ChildName, ChildSurname, DateOfBirth, Sex, EntryDate, FK_Group, ActivityStatus, PaymentDate, PaymentPeriod, PaymentStatus, FK_Parent1, FK_Parent2)" +
                                "VALUES (%s, %s, %s, %s, %s, %d, %s, %s, %d, %s, %d, %d)",
                        c.getName(),
                        c.getSurname(),
                        c.getDateOfBirth(),
                        c.getSex(),
                        c.getEntryDate(),
                        GroupList.locateID(statement, c.getGroup()),
                        c.getActivityStatus(),
                        c.getPaymentDate(),
                        c.getPaymentPeriod(),
                        c.getPaymentStatus(),
                        ParentList.locateID(statement, c.getParent1()),
                        ParentList.locateID(statement, c.getParent2()));

                statement.executeQuery(sql2);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Child getChild(int id){
        for(Child c : waitingList){
            if(c.getId() == id) return c;
        }

        return null;
    }

    public void add(Child child){
        waitingList.add(child);
    }

    public String toString(){
        String result = "";

        for(int i = 0; i < waitingList.size(); i++){
            result += i + ". " + waitingList.get(i).toString();
        }

        return result;
    }
}
