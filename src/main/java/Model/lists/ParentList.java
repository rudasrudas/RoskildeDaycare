package Model.lists;

import Model.data.Parent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                        rs.getInt(6),
                        rs.getString(7)
                ));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}

