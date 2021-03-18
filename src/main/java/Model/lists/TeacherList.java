package Model.lists;

import Model.data.Teacher;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;

public class TeacherList {
    private ArrayList<Teacher> teacherList;

    public TeacherList(Statement statement){
        teacherList = new ArrayList<Teacher>();

        try{
            String sql = "SELECT * FROM roskildedaycare1.class";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                teacherList.add(new Teacher(rs.getString("ColumnName"),
                                            rs.getString("AnotherColumnName")
                                            );
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
