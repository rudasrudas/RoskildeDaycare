import Controller.Controller;
import Model.Model;
import View.View;

import java.sql.*;

public class Daycare {
    public static Model model;
    public static View view;
    public static Controller controller;

    public static void main(String[] args) {
        String url = "jdbc:mysql://den1.mysql6.gear.host:3306";
        String user = "roskildedaycare1";
        String password = "Kd9el?c~CtQE";

        String sql = "SELECT * FROM roskildedaycare1.class";
        try {
            Statement statement = connectDB(url, user, password);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("ClassName"));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        };
    }

    public static Statement connectDB(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        return statement;
    }
}
