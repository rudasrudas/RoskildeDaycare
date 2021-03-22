package build.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import build.Daycare;
import build.Model.Model;
import build.Model.data.*;

public class AddController extends Controller {

    public static void addChild() {
        System.out.println("- Adding a child -");

        String childName = inputString("Child name: ");
        String childSurname = inputString("Child surname: ");
        String dateOfBirth = inputDate("Date of birth (YYYY-MM-DD): ");
        String sex = inputString("Child's sex (Male/Female): ", new String[]{"Male", "Female"});
        String entryDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Group group = Daycare.model.getGroupList().select(Daycare.scanner);
        Parent parent1 = Daycare.model.getParentList().select(Daycare.scanner);
        Parent parent2 = Daycare.model.getParentList().select(Daycare.scanner);

        Child child = new Child(-1,
                childName,
                childSurname,
                dateOfBirth,
                sex,
                entryDate,
                group,
                "Active",
                null,
                0,
                "Unpaid",
                parent1,
                parent2);

        Daycare.model.getChildList().add(child);
        System.out.println("Child added to the system");
    }

    public static void addChildToWaitingList() {
        System.out.println("- Adding a child to the waiting list -");

        String childName = inputString("Child name: ");
        String childSurname = inputString("Child surname: ");
        String dateOfBirth = inputDate("Date of birth (YYYY-MM-DD): ");
        String sex = inputString("Child's sex (Male/Female): ", new String[]{"Male", "Female"});
        String joinDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Parent parent1 = Daycare.model.getParentList().select(Daycare.scanner);
        Parent parent2 = Daycare.model.getParentList().select(Daycare.scanner);

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

    public static void registerUser() {
        System.out.println("- Registering new user -");

        String username = inputString("Username: ");
        String password = hash(inputString("Password: "));
        int authorisation = inputInt("Authorisation level (1 -- Administrator, 2 -- Teacher): ", new int[]{1, 2});

        if (username.equals("") || password.equals("") || authorisation < 0) {
            System.out.println("Insufficient information. Exiting.");
            return;
        }

        UserAccount userAccount = new UserAccount(-1, username, password, authorisation);
        Daycare.model.getUserAccountList().add(userAccount);
        System.out.println("User account registered.");
    }

    public static void addGroup() {
        System.out.println("- Adding a group -");

        String name = inputString("Group name: ");

        Group group = new Group(-1, name);
        Daycare.model.getGroupList().add(group);
        System.out.println("Group added");
    }

    public static void addGuardian() {
        System.out.println("- Adding a guardian -");

        String parentPrefix = inputString("Prefix: ");
        String parentName = inputString("Parent name: ");
        String parentSurname = inputString("Parent surname: ");
        String relationship = inputString("Relationship to child: ");
        String phoneNumber = inputString("Phone Number: ");
        String email = inputString("Email Address: ");
        Address address = Daycare.model.getAddressList().select(Daycare.scanner);

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

    public static void addTeacher() {
        System.out.println("- Adding a teacher -");

        String teacherPrefix = inputString("Prefix: ");
        String teacherName = inputString("Teacher name: ");
        String teacherSurname = inputString("Teacher surname: ");
        Group group = Daycare.model.getGroupList().select(Daycare.scanner);
        String phoneNumber = inputString("Phone Number: ");
        String email = inputString("Email Address: ");
        Address address = Daycare.model.getAddressList().select(Daycare.scanner);
        BankInfo bankInfo = Daycare.model.getBankInfoList().select(Daycare.scanner);

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

    public static void addBankInfo() {
        System.out.println("- Adding bank credentials -");

        String BankName = inputString("Bank name: ");
        String AccountName = inputString("Account first name: ");
        String AccountSurname = inputString("Account surname: ");
        int AccountNumber = inputInt("Account number: ");
        int RegNumber = inputInt("Registry number: ");
        int KontoNumber = inputInt("Konto number: ");

        BankInfo bankInfo = new BankInfo(-1,
                BankName,
                AccountName,
                AccountSurname,
                AccountNumber,
                RegNumber,
                KontoNumber);

        Daycare.model.getBankInfoList().add(bankInfo);
        System.out.println("Your Bank account details have been added");
    }

    public static void addAddress() {
        System.out.println("- Adding an address -");

        String city = inputString("City name: ");
        int postcode = inputInt("Postcode: ");
        String streetName = inputString("Street name: ");
        int streetNumber = inputInt("Street number: ");
        int floorNumber = inputInt("Floor number: ");
        int apartmentNumber = inputInt("Apartment number: ");
        String careOfName = inputString("Care of (first name): ");
        String careOfSurename = inputString("Care of (second name): ");

        Address address = new Address(-1,
                city,
                postcode,
                streetName,
                streetNumber,
                floorNumber,
                apartmentNumber,
                careOfName,
                careOfSurename);


        Daycare.model.getAddressList().add(address);
        System.out.println("Your address has been added");

    }
}