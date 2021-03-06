package build.Model.lists;

import build.Model.data.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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
            statement.executeUpdate(sql1);

            for(Child c : waitingList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.waitinglist (ChildName, ChildSurname, DateOfBirth, Sex, JoinDate, FK_Parent1, FK_Parent2)" +
                                "VALUES ('%s', '%s', '%s', '%s', '%s', '%d', '%d')",
                        c.getName(),
                        c.getSurname(),
                        c.getDateOfBirth(),
                        c.getSex(),
                        c.getEntryDate(),
                        (c.getParent1() == null ? -1 : c.getParent1().getId()),
                        (c.getParent2() == null ? -1 : c.getParent2().getId()));

                int id = statement.executeUpdate(sql2, Statement.RETURN_GENERATED_KEYS);
                c.setId(id);
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

    public void remove(Child child){
        waitingList.remove(child);
    }

    public String toString(){
        String result = "";

        for(int i = 0; i < waitingList.size(); i++){
            result += i + ". " + waitingList.get(i).toString() + "\n";
        }

        return result;
    }

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
        while(index < 0 || index >= waitingList.size());

        return waitingList.get(index);
    }
}
