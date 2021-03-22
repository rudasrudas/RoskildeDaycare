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

    public static void updateWaitingList(){
        System.out.println("- Updating child information -");

        Child child = Daycare.model.getWaitingList().select(Daycare.scanner);

        if(isNull(child)){ return; }

        String column = inputString("What do you want to edit (Name/Surname/DateOfBirth/Sex)?:", new String[]{"Name", "Surname", "DateOfBirth", "Sex"});

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
            default:
                System.out.println("Unrecognized method, exiting");
                break;
        }

        System.out.println("Child information updated in the waiting list.");
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

    public static void updateParent(){
        System.out.println("- Updating Parent information -");

        Parent parent = Daycare.model.getParentList().select(Daycare.scanner);

        if(isNull(parent)){ return; }

        String column = inputString("What do you want to edit (Prefix/Name/Surname/PhoneNumber/Email)?:", new String[]{"Prefix", "Name", "Surname", "PhoneNumber", "Email"});

        switch(column){
            case "Prefix":
                String prefix = inputString("New prefix: ");
                if(isNull(prefix)){ return; }
                parent.setPrefix(prefix);
                break;
            case "Name":
                String name = inputString("New Name: ");
                if(isNull(name)){ return; }
                parent.setName(name);
                break;
            case "Surname":
                String surname = inputDate("New Surname: ");
                if(isNull(surname)){ return; }
                parent.setSurname(surname);
                break;
            case "Phone Number":
                String phoneNumber = inputString("New Phone Number: ");
                if(isNull(phoneNumber)){ return; }
                parent.setPhoneNumber(phoneNumber);
                break;
            case "Email":
                String email = inputString("New Email");
                if(isNull(email)){ return; }
                parent.setEmail(email);
                break;
            default:
                System.out.println("Unrecognized method, exiting");
                break;
        }

        System.out.println("Parent information has been updated.");
    }

    public static void updateTeacher(){
        System.out.println("- Updating teacher information -");

        Teacher teacher = Daycare.model.getTeacherList().select(Daycare.scanner);

        if(isNull(teacher)){ return; }

        String column = inputString("What do you want to edit (Prefix/Name/Surname/PhoneNumber/Email)?:", new String[]{"Prefix", "Name", "Surname", "PhoneNumber", "Email"});

        switch(column){
            case "Prefix":
                String prefix = inputString("New prefix: ");
                if(isNull(prefix)){ return; }
                teacher.setPrefix(prefix);
                break;
            case "Name":
                String name = inputString("New Name: ");
                if(isNull(name)){ return; }
                teacher.setName(name);
                break;
            case "Surname":
                String surname = inputDate("New Surname: ");
                if(isNull(surname)){ return; }
                teacher.setSurname(surname);
                break;
            case "Phone Number":
                String phoneNumber = inputString("New Phone Number: ");
                if(isNull(phoneNumber)){ return; }
                teacher.setPhoneNumber(phoneNumber);
                break;
            case "Email":
                String email = inputString("New Email");
                if(isNull(email)){ return; }
                teacher.setEmail(email);
                break;
            default:
                System.out.println("Unrecognized method, exiting");
                break;
        }

        System.out.println("Child information updated in the waiting list.");
    }
}
