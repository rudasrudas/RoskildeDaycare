package build.Controller;

import build.Daycare;
import build.Model.data.*;
import build.View.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateController extends Controller{

    public static void updateChild(){
        View.renderBlock("- Updating child information -");

        Child child = Daycare.model.getChildList().select(Daycare.scanner);

        if(isNull(child)){ return; }

        String column = inputString("What do you want to edit (Name/Surname/DateOfBirth/Sex/Group/Status)?:", new String[]{"Name", "Surname", "DateOfBirth", "Sex", "Group", "Status"});

        if(isNull(column)) return;

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
                errorMessage("Unrecognized method, exiting");
                break;
        }

        successMessage("Child information updated.");
    }

    public static void updateWaitingList(){
        View.renderBlock("- Updating child information -");

        Child child = Daycare.model.getWaitingList().select(Daycare.scanner);

        if(isNull(child)){ return; }

        String column = inputString("What do you want to edit (Name/Surname/DateOfBirth/Sex)?:", new String[]{"Name", "Surname", "DateOfBirth", "Sex"});

        if(isNull(column)) return;

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
                errorMessage("Unrecognized method, exiting");
                break;
        }

        successMessage("Child information updated in the waiting list.");
    }

    public static void updateGroup(){
        View.renderBlock("- Updating group information -");

        Group group = Daycare.model.getGroupList().select(Daycare.scanner);

        if(isNull(group)){ return; }

        System.out.println("You can only change the group name.");

        String name = inputString("New group name: ");
        if(isNull(name)){ return; }
        group.setGroupName(name);

        successMessage("Group name updated.");
    }

    public static void updateParent(){
        View.renderBlock("- Updating Parent information -");

        Parent parent = Daycare.model.getParentList().select(Daycare.scanner);

        if(isNull(parent)){ return; }

        String column = inputString("What do you want to edit (Prefix/Name/Surname/PhoneNumber/Email)?:", new String[]{"Prefix", "Name", "Surname", "PhoneNumber", "Email"});

        if(isNull(column)) return;

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
                String surname = inputString("New Surname: ");
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
                errorMessage("Unrecognized method, exiting");
                break;
        }

        successMessage("Parent information has been updated.");
    }

    public static void updateTeacher(){
        View.renderBlock("- Updating teacher information -");

        Teacher teacher = Daycare.model.getTeacherList().select(Daycare.scanner);

        if(isNull(teacher)){ return; }

        String column = inputString("What do you want to edit (Prefix/Name/Surname/Group/BankInfo/PhoneNumber/Email)?:", new String[]{"Prefix", "Name", "Surname", "Group", "BankInfo", "PhoneNumber", "Email"});

        if(isNull(column)) return;

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
                String surname = inputString("New Surname: ");
                if(isNull(surname)){ return; }
                teacher.setSurname(surname);
                break;
            case "Group":
                Group group = Daycare.model.getGroupList().select(Daycare.scanner);
                teacher.setGroup(group);
                break;
            case "BankInfo":
                BankInfo bankInfo = Daycare.model.getBankInfoList().select(Daycare.scanner);
                if(isNull(bankInfo)){ return; }
                teacher.setBankInfo(bankInfo);
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
                errorMessage("Unrecognized method, exiting");
                break;
        }

        successMessage("Teacher information updated.");
    }

    public static void updateAccount(){
        View.renderBlock("- Updating account information -");

        UserAccount userAccount = Daycare.model.getUserAccountList().select(Daycare.scanner);

        if(isNull(userAccount)){ return; }

        String column = inputString("What do you want to edit (Username/Password/Authorization)?:", new String[]{"Username", "Password", "Authorization"});

        if(isNull(column)) return;

        switch(column){
            case "Prefix":
                String username = inputString("New Username: ");
                if(isNull(username)){ return; }
                userAccount.setUsername(username);
                break;
            case "":
                String password = inputString("New Password: ");
                if(isNull(password)){ return; }
                userAccount.setPassword(password);
                break;
            case "Authorization":
                int authorization = inputInt("New Authorization level (1 -- Administrator, 2 -- Teacher): ", new int[]{1, 2});
                if(isNull(authorization)){ return; }
                userAccount.setAuthorisation(authorization);
                break;
            default:
                errorMessage("Unrecognized method, exiting");
                break;
        }

        successMessage("Child information updated in the waiting list.");
    }

    public static void acceptChild(){
        View.renderBlock("- Transferring Child from Waiting List -");

        Child child = Daycare.model.getWaitingList().select(Daycare.scanner);

        if(isNull(child)) return;

        Daycare.model.getChildList().add(child);
        Daycare.model.getWaitingList().remove(child);

        child.setEntryDate(new SimpleDateFormat("yyy-MM-dd").format(new Date()));
        child.setActivityStatus("Active");

        successMessage("Child has been removed from the waiting list and added to the active list.");
    }

    public static void registerPayment(){
        View.renderBlock("- Registering a payment -");

        Child child = Daycare.model.getChildList().select(Daycare.scanner);

        if(isNull(child)) return;

        String date = inputDate("Payment date: ");
        int period = inputInt("Payment period in days: ");
        String status = inputString("(Paid/Unpaid)?: ", new String[]{"Paid", "Unpaid"});

        if(isNull(date) || isNull(period) || isNull(status)) return;

        child.setPaymentDate(date);
        child.setPaymentPeriod(period);
        child.setPaymentStatus(status);

        successMessage("Payment registered");
    }

}
