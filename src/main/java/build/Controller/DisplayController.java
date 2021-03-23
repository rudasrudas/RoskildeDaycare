package build.Controller;

import build.Daycare;
import build.View.View;
import build.Model.data.*;

public class DisplayController extends Controller {

    public static void displayChild(){
        View.renderBlock("- Children List -");

        Child child = Daycare.model.getChildList().select(Daycare.scanner);

        if(child == null) return;

        View.renderBlock("- Information about child -");

        System.out.println("Name: " + child.getName());
        System.out.println("Surname: " + child.getSurname());
        System.out.println("Date of birth: " + child.getDateOfBirth());
        System.out.println("Sex: " + child.getSex());
        System.out.println("Entry date: " + child.getEntryDate());
        System.out.print("Group: ");
        if(child.getGroup() == null) {
            System.out.println("Unassigned");
        }
        else{
            System.out.println(child.getGroup().getGroupName());
        }
        System.out.println("Activity status: " + child.getActivityStatus());

        System.out.println("Payment information: ");
        if(child.getPaymentDate() == null){
            System.out.println("\tNot paid");
        }
        else {
            System.out.println("\tdate: " + child.getPaymentDate());
            System.out.println("\tperiod: " + child.getPaymentPeriod() + " days");
            System.out.println("\tstatus: " + child.getPaymentStatus());
        }

        System.out.println("First guardian: ");
        if(child.getParent1() == null){
            System.out.println("\tUnassigned");
        }
        else {
            System.out.println("\t" + child.getParent1().getPrefix() + ". " + child.getParent1().getName() + " " + child.getParent1().getSurname() + "(" + child.getParent1().getRelationship() + ")");
            System.out.println("\tPhone: " + child.getParent1().getPhoneNumber() + "\n\tEmail: " + child.getParent1().getEmail());
            try{ System.out.println("\tAddress: " + child.getParent1().getAddress().toString()); }
            catch(Exception e){ }
        }

        System.out.println("Second guardian: ");
        if(child.getParent2() == null){
            System.out.println("\tUnassigned");
        }
        else {
            System.out.println("\t" + child.getParent2().getPrefix() + ". " + child.getParent2().getName() + " " + child.getParent2().getSurname() + "(" + child.getParent2().getRelationship() + ")");
            System.out.println("\t Phone: " + child.getParent2().getPhoneNumber() + "\n\t Email: " + child.getParent2().getEmail());
            if(child.getParent1().getAddress() != null)
                System.out.println("\t" + child.getParent2().getAddress().toString());
        }

        System.out.println("\nPress Enter to return...");
        Daycare.scanner.nextLine();
    }

    public static void displayGuardian(){
        View.renderBlock("- Parent & Guardian List -");

        Parent parent = Daycare.model.getParentList().select(Daycare.scanner);

        if(parent == null) return;

        View.renderBlock("- Information about parent -");

        System.out.println("Prefix: " + parent.getPrefix());
        System.out.println("Name: " + parent.getName());
        System.out.println("Surname: " + parent.getSurname());
        System.out.println("Relationship: " + parent.getRelationship());
        System.out.println("Phone Number: " + parent.getPhoneNumber());
        System.out.println("Email: " + parent.getEmail());
        System.out.print("Address: ");
        if(parent.getAddress() == null) {
            System.out.println("Unassigned");
        }
        else{
            System.out.println(parent.getAddress().toString());
        }

        System.out.println("\nPress Enter to return...");
        Daycare.scanner.nextLine();
    }

    public static void displayGroup(){
        View.renderBlock("- Group List -");

        Group group = Daycare.model.getGroupList().select(Daycare.scanner);

        if(group == null) return;

        View.renderBlock("- Information about group -");

        System.out.println("Group Name: " + group.getGroupName());

        System.out.println("\nPress Enter to return...");
        Daycare.scanner.nextLine();
    }

    public static void displayTeacher(){
        View.renderBlock("- Teacher List -");

        Teacher teacher = Daycare.model.getTeacherList().select(Daycare.scanner);

        if(teacher == null) return;

        View.renderBlock("- Information about teacher -");

        System.out.println("Prefix: " + teacher.getPrefix());
        System.out.println("Name: " + teacher.getName());
        System.out.println("Surname: " + teacher.getSurname());
        System.out.println("Group: ");
        if(teacher.getGroup() == null){
            System.out.println("Unassigned");
        }else{
            System.out.println(teacher.getGroup().getGroupName());
        }
        System.out.println("Phone Number: " + teacher.getPhoneNumber());
        System.out.println("Email: " + teacher.getEmail());
        System.out.print("Address: ");
        if(teacher.getAddress() == null) {
            System.out.println("Unassigned");
        }
        else{
            System.out.println(teacher.getAddress().toString());
        }
        System.out.println("Bank Information: ");
        if (teacher.getBankInfo() == null){
            System.out.println("Unassigned");
        }else{
            System.out.println(teacher.getBankInfo().toString());
        }

        System.out.println("\nPress Enter to return...");
        Daycare.scanner.nextLine();
    }

    public static void displayWaitingList(){
        View.renderBlock("- Waiting List -");

        Child child = Daycare.model.getWaitingList().select(Daycare.scanner);

        if(child == null) return;

        View.renderBlock("- Information about waiting list -");

        System.out.println("Name: " + child.getName());
        System.out.println("Surname: " + child.getSurname());
        System.out.println("Date of birth: " + child.getDateOfBirth());
        System.out.println("Sex: " + child.getSex());
        System.out.println("Join date: " + child.getEntryDate());
        System.out.println("First guardian: ");
        if(child.getParent1() == null){
            System.out.println("\tUnassigned");
        }
        else {
            System.out.println("\t" + child.getParent1().getPrefix() + ". " + child.getParent1().getName() + " " + child.getParent1().getSurname() + "(" + child.getParent1().getRelationship() + ")");
            System.out.println("\tPhone: " + child.getParent1().getPhoneNumber() + "\n\t Email: " + child.getParent1().getEmail());
            if(child.getParent1().getAddress() != null)
                System.out.println("\t" + child.getParent1().getAddress().toString());
        }

        System.out.println("Second guardian: ");
        if(child.getParent2() == null){
            System.out.println("\tUnassigned");
        }
        else {
            System.out.println("\t" + child.getParent2().getPrefix() + ". " + child.getParent2().getName() + " " + child.getParent2().getSurname() + "(" + child.getParent2().getRelationship() + ")");
            System.out.println("\tPhone: " + child.getParent2().getPhoneNumber() + "\n\tEmail: " + child.getParent2().getEmail());
            try{ System.out.println("\tAddress: " + child.getParent2().getAddress().toString()); }
            catch(Exception e){ }
        }

        System.out.println("\nPress Enter to return...");
        Daycare.scanner.nextLine();
    }
}
