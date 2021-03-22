package build.Model.lists;

import build.Model.data.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void saveToDatabase(Statement statement){
        try{
            String sql1 = "TRUNCATE TABLE roskildedaycare1.child";
            statement.executeUpdate(sql1);

            for(Child c : childList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.child (ChildName, ChildSurname, DateOfBirth, Sex, EntryDate, FK_Group, ActivityStatus, PaymentDate, PaymentPeriod, PaymentStatus, FK_Parent1, FK_Parent2) VALUES ('%s', '%s', '%s', '%s', '%s', '%d', '%s', '%s', '%d', '%s', '%d', '%d')",
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

                statement.executeUpdate(sql2);
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
            result += i + ". " + childList.get(i).toString() + "\n";
        }

        return result;
    }

    public void add(Child child){
        childList.add(child);
    }
    public void remove(Child child){ childList.remove(child); }

    public Child select(Scanner scanner){

        int index;
        String input;

        do {
            try {
                System.out.println("Please select a child: ");
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
        while(index < 0 || index >= childList.size());

        return childList.get(index);
    }
}
