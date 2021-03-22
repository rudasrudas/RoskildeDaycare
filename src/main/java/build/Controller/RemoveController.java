package build.Controller;

import build.Daycare;
import build.Model.data.*;

public class RemoveController extends Controller {

    public static void removeChild(){
        System.out.println("- Removing a child -");

        Child child = Daycare.model.getChildList().select(Daycare.scanner);

        if(child == null){
            System.out.println("Insufficient information, exiting.");
            return;
        }

        String confirmation = inputString("Are you sure you want to remove the following child from the system (Yes/No)?\n" + child + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getChildList().remove(child);
            System.out.println("Child removed from the waiting list");
        }
    }

    public static void removeChildFromWaitingList(){
        System.out.println("- Removing a child from the waiting list -");

        Child child = Daycare.model.getWaitingList().select(Daycare.scanner);

        if(child == null){
            System.out.println("Insufficient information, exiting.");
            return;
        }

        String confirmation = inputString("Are you sure you want to remove the following child from the waiting list (Yes/No)?\n" + child + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getChildList().remove(child);
            System.out.println("Child removed from the waiting list");
        }
    }

    public static void removeGuardian(){
        System.out.println("- Removing a parent -");

        Parent parent = Daycare.model.getParentList().select(Daycare.scanner);

        if(parent == null){
            System.out.println("Insufficient information, exiting.");
            return;
        }

        String confirmation = inputString("Are you sure you want to remove the following parent from the system (Yes/No)?\n" + parent + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getParentList().remove(parent);
        }
    }

    public static void removeClass(){
        System.out.println("- Removing a Class -");

        Group group = Daycare.model.getGroupList().select(Daycare.scanner);

        if(group == null){
            System.out.println("Insufficient information, exiting.");
            return;
        }

        String confirmation = inputString("Are you sure you want to remove the following group from the system (Yes/No)?\n" + group + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getGroupList().remove(group);
        }
    }

    public static void removeTeacher(){
        System.out.println("- Removing a Teacher -");

        Teacher teacher = Daycare.model.getTeacherList().select(Daycare.scanner);

        if(teacher == null){
            System.out.println("Insufficient information, exiting.");
            return;
        }

        String confirmation = inputString("Are you sure you want to remove the following teacher from the system (Yes/No)?\n" + teacher + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getTeacherList().remove(teacher);
        }
    }
}
