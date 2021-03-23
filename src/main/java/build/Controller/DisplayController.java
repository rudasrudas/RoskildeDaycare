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

        System.out.println("First parent: ");
        if(child.getParent1() == null){
            System.out.println("\tUnassigned");
        }
        else {
            System.out.println("\t" + child.getParent1().getPrefix() + ". " + child.getParent1().getName() + " " + child.getParent1().getSurname() + "(" + child.getParent1().getRelationship() + ")");
            System.out.println("\tPhone: " + child.getParent1().getPhoneNumber() + "\n\tEmail: " + child.getParent1().getEmail());
            try{ System.out.println("\tAddress: " + child.getParent1().getAddress().toString()); }
            catch(Exception e){ }
        }

        System.out.println("Second parent: ");
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
