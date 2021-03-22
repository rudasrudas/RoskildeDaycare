package build.Controller;

import build.Daycare;
import build.Model.data.*;
import build.View.View;

public class RemoveController extends Controller {

    public static void removeChild(){
        View.renderBlock("- Removing a child -");

        Child child = Daycare.model.getChildList().select(Daycare.scanner);

        if(isNull(child)){ return; }

        String confirmation = inputString("Are you sure you want to remove the following child from the system (Yes/No)?\n" + child + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getChildList().remove(child);
            successMessage("Child removed from the system");
        }
    }

    public static void removeChildFromWaitingList(){
        View.renderBlock("- Removing a child from the waiting list -");

        Child child = Daycare.model.getWaitingList().select(Daycare.scanner);

        if(isNull(child)){ return; }

        String confirmation = inputString("Are you sure you want to remove the following child from the waiting list (Yes/No)?\n" + child + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getChildList().remove(child);
            successMessage("Child removed from the waiting list");
        }
    }

    public static void removeGuardian(){
        View.renderBlock("- Removing a guardian -");

        Parent parent = Daycare.model.getParentList().select(Daycare.scanner);

        if(isNull(parent)){ return; }

        String confirmation = inputString("Are you sure you want to remove the following parent from the system (Yes/No)?\n" + parent + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getParentList().remove(parent);
            successMessage("Guardian removed from the system");
        }
    }

    public static void removeGroup(){
        View.renderBlock("- Removing a Class -");

        Group group = Daycare.model.getGroupList().select(Daycare.scanner);

        if(isNull(group)){ return; }

        String confirmation = inputString("Are you sure you want to remove the following group from the system (Yes/No)?\n" + group + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getGroupList().remove(group);
            successMessage("Group removed from the system");
        }
    }

    public static void removeTeacher(){
        View.renderBlock("- Removing a Teacher -");

        Teacher teacher = Daycare.model.getTeacherList().select(Daycare.scanner);

        if(isNull(teacher)){ return; }

        String confirmation = inputString("Are you sure you want to remove the following teacher from the system (Yes/No)?\n" + teacher + "\n", new String[]{"Yes", "No"});
        if(confirmation.equals("Yes")){
            Daycare.model.getTeacherList().remove(teacher);
            successMessage("Teacher removed from the system");
        }
    }
}
