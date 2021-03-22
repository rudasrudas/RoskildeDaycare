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
}
