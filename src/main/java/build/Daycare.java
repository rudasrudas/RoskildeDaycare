package build;

import build.Model.Model;

import java.sql.*;
import build.Controller.*;
import build.Model.data.UserAccount;
import build.View.View;
import java.util.*;

public class Daycare {
    public static Model model;

    public static AddController addController;
    public static UpdateController updateController;
    public static RemoveController removeController;
    public static DisplayController displayController;

    public static View view;

    public static UserAccount user;
    public static Scanner scanner;

    public static Statement statement;

    public static void main(String[] args) throws SQLException{
        Daycare daycare = new Daycare();
    }

    public Daycare() throws SQLException{

        statement = connectDB();
        model = new Model(statement);
        scanner = new Scanner(System.in);

        view = new View();
        view.viewLoginMenu();
    }

    public static Statement connectDB() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306", "roskildedaycare1", "Kd9el?c~CtQE");
        Statement statement = connection.createStatement();
        return statement;
    }
}
