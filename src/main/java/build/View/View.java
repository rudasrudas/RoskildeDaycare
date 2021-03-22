package build.View;

import build.Daycare;
import build.Controller.Controller;
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

        int result = Controller.inputInt("Select action (0-" + (j-1) + "): ", options);

        //Backwards mapping the selected button to the actual action
        for(int i = actions.length - 1, k = j; i >= 0 ; i--){
            if(accessLevels[i] >= userAccessLevel){ k--; }
            if(k == result) return i;
        }

        return -1; //not found
    }

    public static void viewLoginMenu(){

    }

    public static void logOut(){
        Daycare.model.saveModel(Daycare.statement);
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

        switch(createMenuInput(actions, accessLevels, 2)){
            case 0 -> viewAddMenu();
            case 1 -> viewUpdateMenu();
            case 2 -> viewRemoveMenu();
            case 3 -> viewDisplayMenu();
            case 4 -> logOut();
        }
    }

    public static void viewAddMenu(){
        String[] actions = {
                "Register new account",
                "Add child",
                "Add guardian",
                "Add teacher",
                "Add address",
                "Add bank credentials",
                "Return"};

        int[] accessLevels = {0, 1, 1, 0, 1, 0, 2};

        clearScreen();

        switch(createMenuInput(actions, accessLevels, 2)){
            case 0 -> Daycare.addController.registerUser();
            case 1 -> Daycare.addController.addChild();
            case 2 -> Daycare.addController.addGuardian();
            case 3 -> Daycare.addController.addTeacher();
            case 4 -> Daycare.addController.addAddress();
            case 5 -> Daycare.addController.addBankInfo();
            case 6 -> viewMainMenu();
        }
    }

    public static void viewUpdateMenu(){
        String[] actions = {
                "Accept child",
                "Update child information",
                "Update guardian information",
                "Update teacher information",
                "Update group information",
                "Update account information",
                "Return"};

        int[] accessLevels = {1, 2, 2, 0, 0, 0, 2};

        clearScreen();

        switch(createMenuInput(actions, accessLevels, 2)){
            //case 0 -> Daycare.updateController.acceptChild();
            case 1 -> Daycare.updateController.updateChild();
            //case 2 -> Daycare.updateController.updateGuardian();
            //case 3 -> Daycare.updateController.updateTeacher();
            case 4 -> Daycare.updateController.updateGroup();
            //case 5 -> Daycare.updateController.updateUser();
            case 6 -> viewMainMenu();
        }
    }

    public static void viewRemoveMenu(){

    }

    public static void viewDisplayMenu(){

    }
}
