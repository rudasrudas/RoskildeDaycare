package build.View;

import build.Daycare;
import build.Controller.Controller;
import build.Model.Model;
import build.Model.data.UserAccount;

import java.sql.*;

public class View {

    public static void clearScreen(){
        for(int i = 0; i < 30; i++)
            System.out.println();
    }

    public static void renderButton(String text, int index){
        int blockWidth = 35; //width of the block in symbols

        if(text.length() + 3 > blockWidth){
            blockWidth = text.length() + 3;
        }

        //Top
        System.out.print("┌");
        for(int i = 0; i < blockWidth; i++){
            System.out.print("─");
        }
        System.out.println("┐");

        //Middle
        int padding = (blockWidth - text.length() - 3);
        System.out.print("│");
        for(int i = 0; i < padding/2 + padding%2; i++){
            System.out.print(" ");
        }

        System.out.print(index + ". " + text);

        for(int i = 0; i < padding/2; i++){
            System.out.print(" ");
        }
        System.out.println("│");

        //Bottom
        System.out.print("└");
        for(int i = 0; i < blockWidth; i++){
            System.out.print("─");
        }
        System.out.println("┘");
    }

    public static int createMenuInput(String[] actions, int[] accessLevels, int userAccessLevel){

        if(actions.length != accessLevels.length) return -1; //Insufficient parameters

        int j = 0;
        for(int i = 0; i < actions.length; i++){
            if(accessLevels[i] >= userAccessLevel){ //If user can access the button, then render it.
                renderButton(actions[i], j);
                j++;
            }
        }

        int[] options = new int[j];
        for(int i = 0; i < j; i++){
            options[i] = i;
        }

        int result = Controller.inputInt("\nSelect action (0-" + (j-1) + "): ", options);

        //Backwards mapping the selected button to the actual action
        for(int i = actions.length - 1, k = j; i >= 0 ; i--){
            if(accessLevels[i] >= userAccessLevel){ k--; }
            if(k == result) return i;
        }

        return -1; //not found
    }

    public static void renderBlock(String text){
        final int blockWidth = 40;

        clearScreen();

        //Top
        System.out.print("┌");
        for(int i = 0; i < blockWidth; i++){ System.out.print("─"); }
        System.out.println("┐");

        //Middle
        int padding = (blockWidth - text.length());
        System.out.print("│");
        for(int i = 0; i < padding/2 + padding%2; i++){ System.out.print(" "); }
        System.out.print(text);
        for(int i = 0; i < padding/2; i++){ System.out.print(" "); }
        System.out.println("│");

        //Bottom
        System.out.print("└");
        for(int i = 0; i < blockWidth; i++){ System.out.print("─"); }
        System.out.println("┘");

        System.out.println();
    }

    public static void viewLoginMenu(){

        renderBlock("- Welcome to Roskilde Daycare -");

        UserAccount account = Controller.logIn();
        if(account != null) {
            Daycare.user = account;

            try {
                Daycare.statement = Daycare.connectDB();
                Daycare.model = new Model(Daycare.statement);
            }
            catch (SQLException e){
                e.printStackTrace();
            }

            viewMainMenu();
        }

        viewLoginMenu();
    }

    public static void logOut(){

        renderBlock("- Logging out. Have a nice day! -");

        Daycare.model.saveModel(Daycare.statement);

        try {
            Daycare.statement.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        viewLoginMenu();
    }

    public static void viewMainMenu(){
        String[] actions = {
                "Add information",
                "Update information",
                "Remove information",
                "View information",
                "Log out"};

        int[] accessLevels = {1, 2, 1, 2, 2};

        clearScreen();

        switch(createMenuInput(actions, accessLevels, Daycare.user.getAuthorisation())){
            case 0 -> viewAddMenu();
            case 1 -> viewUpdateMenu();
            case 2 -> viewRemoveMenu();
            case 3 -> viewDisplayMenu();
            case 4 -> logOut();
        }

        viewMainMenu(); //Looping back
    }

    public static void viewAddMenu(){
        String[] actions = {
                "Register new account",
                "Add child",
                "Add child to the waiting list",
                "Add guardian",
                "Add teacher",
                "Add address",
                "Create group",
                "Add bank credentials",
                "Return"};

        int[] accessLevels = {0, 1, 2, 1, 0, 1, 0, 0, 2};

        clearScreen();

        switch(createMenuInput(actions, accessLevels, Daycare.user.getAuthorisation())){
            case 0 -> Daycare.addController.registerUser();
            case 1 -> Daycare.addController.addChild();
            case 2 -> Daycare.addController.addChildToWaitingList();
            case 3 -> Daycare.addController.addGuardian();
            case 4 -> Daycare.addController.addTeacher();
            case 5 -> Daycare.addController.addAddress();
            case 6 -> Daycare.addController.addGroup();
            case 7 -> Daycare.addController.addBankInfo();
            //case 8 -> viewMainMenu();
        }
    }

    public static void viewUpdateMenu(){
        String[] actions = {
                "Accept child",
                "Register payment",
                "Update child information",
                "Update guardian information",
                "Update teacher information",
                "Update group information",
                "Update account information",
                "Return"};

        int[] accessLevels = {1, 1, 2, 2, 0, 0, 0, 2};

        clearScreen();

        switch(createMenuInput(actions, accessLevels, Daycare.user.getAuthorisation())){
            case 0 -> Daycare.updateController.acceptChild();
            case 1 -> Daycare.updateController.registerPayment();
            case 2 -> Daycare.updateController.updateChild();
            case 3 -> Daycare.updateController.updateParent();
            case 4 -> Daycare.updateController.updateTeacher();
            case 5 -> Daycare.updateController.updateGroup();
            case 6 -> Daycare.updateController.updateAccount();
            //case 7 -> viewMainMenu();
        }
    }

    public static void viewRemoveMenu(){
        String[] actions = {
                "Remove child",
                "Remove from the waiting list",
                "Remove guardian",
                "Remove group",
                "Remove teacher",
                "Return"};

        int[] accessLevels = {0, 1, 0, 0, 0, 2};

        clearScreen();

        switch(createMenuInput(actions, accessLevels, Daycare.user.getAuthorisation())){
            case 0 -> Daycare.removeController.removeChild();
            case 1 -> Daycare.removeController.removeChildFromWaitingList();
            case 2 -> Daycare.removeController.removeGuardian();
            case 3 -> Daycare.removeController.removeGroup();
            case 4 -> Daycare.removeController.removeTeacher();
            //case 5 -> viewMainMenu();
        }
    }

    public static void viewDisplayMenu(){
        String[] actions = {
                "View child information",
                "View waiting list",
                "View guardian information",
                "View group information",
                "View teacher information",
                "Return"};

        int[] accessLevels = {2, 1, 2, 2, 1, 2};

        clearScreen();

        switch(createMenuInput(actions, accessLevels, Daycare.user.getAuthorisation())){
            case 0 -> Daycare.displayController.displayChild();
            case 1 -> Daycare.displayController.displayWaitingList();
            case 2 -> Daycare.displayController.displayGuardian();
            case 3 -> Daycare.displayController.displayGroup();
            case 4 -> Daycare.displayController.displayTeacher();
            //case 6 -> viewMainMenu();
        }
    }
}
