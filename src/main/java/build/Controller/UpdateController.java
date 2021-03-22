package build.Controller;

import build.Daycare;
import build.Model.data.*;

public class UpdateController extends Controller{

    public static void updateChild(){
        System.out.println("- Updating child information -");

        Child child = Daycare.model.getWaitingList().select(Daycare.scanner);

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
                String sex = inputString("New sex: ");
                if(isNull(sex)){ return; }
                child.setSurname(sex);
                break;
            case "Group":
                Group group = Daycare.model.getGroupList().select(Daycare.scanner);
                if(isNull(group)){ return; }
                child.setGroup(group);
                break;
            case "Status":
                String status = inputString("New status: ");
                if(isNull(status)){ return; }
                child.setSurname(status);
                break;
            default:
                System.out.println("Unrecognized method, exiting");
                break;
        }

        System.out.println("Child information updated.");
    }
}
