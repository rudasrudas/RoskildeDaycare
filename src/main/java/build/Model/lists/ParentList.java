package build.Model.lists;

import build.Model.data.Parent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ParentList {

    private ArrayList<Parent> parentList;

    public ParentList(Statement statement){
        parentList = new ArrayList<Parent>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.parent";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                parentList.add(new Parent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                ));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void saveToDatabase(Statement statement){
        try{
            String sql1 = "TRUNCATE TABLE roskildedaycare1.parent";
            statement.executeQuery(sql1);

            for(Parent p : parentList) {
                String sql2 = String.format("INSERT INTO roskildedaycare1.parent (Prefix, ParentName, ParentSurname, Relationship, PhoneNumber, Email, FK_Address)" +
                                "VALUES (%s, %s, %s, %s, %s, %s, %d)",
                        p.getPrefix(),
                        p.getName(),
                        p.getSurname(),
                        p.getRelationship(),
                        p.getPhoneNumber(),
                        p.getEmail(),
                        p.getAddress().getId());

                statement.executeQuery(sql2);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Parent getParent(int id){
        for(Parent g : parentList){
            if(g.getId() == id) return g;
        }

        return null;
    }

    public String toString(){
        String result = "";

        for(int i = 0; i < parentList.size(); i++){
            result += i + ". " + parentList.get(i).toString();
        }

        return result;
    }

    public Parent selectParent(Scanner scanner){

        int index;
        String input;

        do {
            try {
                System.out.println("Please select a parent: ");
                System.out.println(toString());
                input = scanner.nextLine();

                if(input == "") return null;

                index = Integer.valueOf(input);
            }
            catch (Exception e){
                System.out.println("Input is incorrect. Try again.");
                index = -1;
            }
        }
        while(index >= 0 && index < parentList.size());

        return parentList.get(index);
    }
}

