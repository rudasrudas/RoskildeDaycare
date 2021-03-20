package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.Model;
import Model.data.Child;
import Model.data.Parent;

public class AddController extends Controller{

    public void addChild(Model model, Scanner s){
        System.out.println("- Adding a child -");

        String childName = inputString("Child name: ", s);
        String childSurname = inputString("Child surname: ", s);
        String dateOfBirth = inputDate("Date of birth (YYYY-MM-DD): ", s);
        String sex = inputString("Child's sex (Male/Female): ", s);
        String joinDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Parent parent1 = model.getParentList().selectParent(s);
        Parent parent2 = model.getParentList().selectParent(s);

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

        model.getWaitingList().add(child);

        System.out.println("Child added to the waiting list");
    }
}
