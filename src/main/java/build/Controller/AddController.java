package build.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import build.Daycare;
import build.Model.Model;
import build.Model.data.Child;
import build.Model.data.Group;
import build.Model.data.Parent;
import build.Model.data.UserAccount;
import build.Model.data.Address;

public class AddController extends Controller{

    public static void addChild(){
        System.out.println("- Adding a child -");

        String childName = inputString("Child name: ");
        String childSurname = inputString("Child surname: ");
        String dateOfBirth = inputDate("Date of birth (YYYY-MM-DD): ");
        String sex = inputString("Child's sex (Male/Female): ", new String[]{"Male", "Female"});
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

        if(username.equals("") || password.equals("") || authorisation < 0){
            System.out.println("Insufficient information. Exiting.");
            return;
        }

        UserAccount userAccount = new UserAccount(-1, username, password, authorisation);
        Daycare.model.getUserAccountList().add(userAccount);
        System.out.println("User account registered.");
    }

    public static void addGroup(){
        System.out.println("- Adding a group -");

        String name = inputString("Group name: ");

        Group group = new Group(-1, name);
        Daycare.model.getGroupList().add(group);
        System.out.println("Group added");
    }

    public static void addGuardian(){
        System.out.println("- Adding a parent/Guardian -");

        String parentPrefix = inputString("Prefix: ");
        String parentName = inputString("Parent name: ");
        String parentSurname = inputString("Parent surname: ");
        String relationship = inputString("Relationship to child: ");
        String phoneNumber = inputString("Phone Number: ");
        String email = inputString("Email Address: ");
        Address address = Daycare.model.getAddressList().selectAddress(Daycare.scanner);

        Parent parent = new Parent(-1,
                parentPrefix,
                parentName,
                parentSurname,
                relationship,
                phoneNumber,
                email,
                address);

        Daycare.model.getParentList().add(parent);
        System.out.println("Child added to the waiting list");
    }

    public static void addTeacher(){
        System.out.println("- Adding a teacher -");

        String teacherPrefix = inputString("Prefix: ");
        String teacherName = inputString("Teacher name: ");
        String teacherSurname = inputString("Teacher surname: ")
        Group group = Daycare.model.getGroupList().selectGroup(Daycare.scanner);
        String phoneNumber = inputString("Phone Number: ");
        String email = inputString("Email Address: ");
        Address address = Daycare.model.getAddressList().selectAddress(Daycare.scanner);
        BankInfo bankInfo = Daycare.model.getBankInfoList().selectBankInfo(Daycare.scanner);

        Teacher teacher = new Teacher(-1,
                teacherPrefix,
                teacherName,
                teacherSurname,
                group,
                phoneNumber,
                email,
                address,
                bankInfo);

        Daycare.model.getTeacherList().add(teacher);
        System.out.println("Teacher added to the teacher");



    }

    public static void addBankInfo(){
        System.out.println("- Adding bank details -");

        BankInfo bankInfo = Daycare.model.getBankInfoList().selectBankInfo(Daycare.scanner);
        String BankName = inputString("Bank name: ");
        String AccountName = inputString("Account first name: ");
        String AccountSurname = inputString("Account surname: ");
        String AccountNumber = inputString("Account number: ");
        String RegNumber = inputString("Registry number: ");
        String KontoNumber = inpurtString("Konto number: ");

        BankInfo bankInfo = new BankInfo(-1,
                BankName,
                AccountName,
                AccountSurname,
                AccountNumber,
                RegNumber,
                KontoNumber);

        Daycare.model.getTeacherList().add(bankInfo);
        System.out.println("Your Bank account details have been added");

}
    public static void addAddress(){
        System.out.println("- Adding Address -");

        Address address = Daycare.model.getAddressList().selectAddress(Daycare.scanner);
        String city = inputString("City name: ")
        String postcode = inputString("postcode: ")
        String StreetName = inputString("Street name: ");
        String StreetNumber = inputString("Street Number: ");
        String CareOfName = inputString("Care of (first name): ");
        String CareOfSurename = inputString("Care of (second name): ");

        Address address = new Adress(-1,
                address,
                city,
                postcode,
                StreetName,
                StreetNumber,
                CareOfName,
                CareOfSurename);


        Daycare.model.getAddressList().add(address);
        System.out.println("Your address has been added");

    }
