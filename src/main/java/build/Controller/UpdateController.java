package build.Controller;

import build.Daycare;
import build.Model.data.*;
import build.View.View;

public class UpdateController extends Controller{

    public static void updateChild(){
        View.renderBlock("- Updating child information -");

        Child child = Daycare.model.getChildList().select(Daycare.scanner);

        if(isNull(child)){ return; }

        String column = inputString("What do you want to edit (Name/Surname/DateOfBirth/Sex/Group/Status)?:", new String[]{"Name", "Surname", "DateOfBirth", "Sex", "Group", "Status"});

        switch(column){
            case "Name":
                String name = inputString("New name: ");
                if(isNull(name)){ return; }
                child.setName(name);
                break;
            case "Surname":
                String surname = inputString("New surname: ");
                if(isNull(surname)){ return; }
                child.setSurname(surname);
                break;
            case "DateOfBirth":
                String dob = inputDate("New date of birth: ");
                if(isNull(dob)){ return; }
                child.setDateOfBirth(dob);
                break;
            case "Sex":
                String sex = inputString("New sex (Male/Female): ", new String[]{"Male", "Female"});
                if(isNull(sex)){ return; }
                child.setSex(sex);
                break;
            case "Group":
                Group group = Daycare.model.getGroupList().select(Daycare.scanner);
                if(isNull(group)){ return; }
                child.setGroup(group);
                break;
            case "Status":
                String status = inputString("New status: ");
                if(isNull(status)){ return; }
                child.setActivityStatus(status);
                break;
            default:
                System.out.println("Unrecognized method, exiting");
                break;
        }

        System.out.println("Child information updated.");
    }

    public static void updateGroup(){
        View.renderBlock("- Updating group information -");

        Group group = Daycare.model.getGroupList().select(Daycare.scanner);

        if(isNull(group)){ return; }

        System.out.println("You can only change the group name.");

        String name = inputString("New group name: ");
        if(isNull(name)){ return; }
        group.setGroupName(name);

        System.out.println("Group name updated.");
    }
}
