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
        String url = "jdbc:mysql://den1.mysql6.gear.host:3306";
        String user = "roskildedaycare1";
        String password = "Kd9el?c~CtQE";

        statement = connectDB(url, user, password);
        model = new Model(statement);
        scanner = new Scanner(System.in);

        view = new View();
        view.viewMainMenu();

        //updateController.updateChild();
        //removeController.removeChild();
        model.saveModel(statement);

    }

    public static Statement connectDB(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        return statement;
    }
}
