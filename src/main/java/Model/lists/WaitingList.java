package Model.lists;

import Model.data.*;

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
                String sql2 = String.format("INSERT INTO roskildedaycare1.child (PK_Child, ChildName, ChildSurname, DateOfBirth, Sex, EntryDate, FK_Group, ActivityStatus, PaymentDate, PaymentPeriod, PaymentStatus, FK_Parent1, FK_Parent2)" +
                                "VALUES (%d, %s, %s, %s, %s, %s, %d, %s, %s, %d, %s, %d, %d)",
                        c.getId(),
                        c.getName(),
                        c.getSurname(),
                        c.getDateOfBirth(),
                        c.getSex(),
                        c.getEntryDate(),
                        c.getGroup().getId(),
                        c.getActivityStatus(),
                        c.getPaymentDate(),
                        c.getPaymentPeriod(),
                        c.getPaymentStatus(),
                        c.getParent1().getId(),
                        c.getParent2().getId());

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

    public String toString(){
        String result = "";

        for(int i = 0; i < waitingList.size(); i++){
            result += i + ". " + waitingList.get(i).toString();
        }

        return result;
    }
}
