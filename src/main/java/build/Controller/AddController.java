package build.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import build.Daycare;
import build.Model.Model;
import build.Model.data.Child;
import build.Model.data.Parent;
import build.Model.data.UserAccount;

public class AddController extends Controller{

    public static void addChild(){
        System.out.println("- Adding a child -");

        String childName = inputString("Child name: ");
        String childSurname = inputString("Child surname: ");
        String dateOfBirth = inputDate("Date of birth (YYYY-MM-DD): ");
        String sex = inputString("Child's sex (Male/Female): ");
        String joinDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Parent parent1 = Daycare.model.getParentList().selectParent(Daycare.scanner);
        Parent parent2 = Daycare.model.getParentList().selectParent(Daycare.scanner);

        Child child = new Child(-1,
                childName,
                childSurname,
                dateOfBirth,
                sex,
                joinDate,
                null,
                "Inactive",
                null,
                0,
                "Unpaid",
                parent1,
                parent2);

        Daycare.model.getWaitingList().add(child);

        System.out.println("Child added to the waiting list");
    }

    public static void registerUser(){
        System.out.println("- Registering new user -");

        String username = inputString("Username: ");
        String password = hash(inputString("Password: "));
        int authorisation = inputInt("Authorisation level (1 -- Administrator, 2 -- Teacher): ", new int[]{1, 2});

        if(username == "" || password == "" || authorisation < 0){
            System.out.println("Insufficient information. Exiting.");
            return;
        }

        UserAccount userAccount = new UserAccount(-1, username, password, authorisation);
        System.out.println("User account registered.");
    }
}
