package build.Controller;

import build.Daycare;
import build.Model.data.UserAccount;
import build.View.View;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Controller {
    public static String inputString(String query, String[] availableInput){

        String result = "";
        boolean sentinel = true;
        while(sentinel){
            sentinel = false;
            try {
                System.out.print(query);
                result = Daycare.scanner.nextLine();

                if(result == "")
                    return null; //If user presses enter without typing anything in, it skips to the next one

                //If there is a set of valid input options, then compare
                if(availableInput.length != 0){
                    boolean found = false;
                    for(int i = 0; i < availableInput.length; i++){
                        if(availableInput[i].equals(result)) found = true;
                    }
                    if(!found) throw new Exception();
                }
            }
            catch(Exception e){
                sentinel = true;
                System.out.println("Your input is incorrect. Try again.");
            }
        }

        return result;
    }

    public static String inputString(String query){
        return inputString(query, new String[]{});
    }

    public static int inputInt(String query, int[] availableInput){

        String result = "";
        int resultInt = -1;
        boolean sentinel;
        do{
            sentinel = false;
            try {
                System.out.print(query);
                result = Daycare.scanner.nextLine();

                if(result == "")
                    return -1;

                resultInt = Integer.valueOf(result);

                //If not an available input
                if(availableInput.length != 0){
                    boolean found = false;
                    for(int i = 0; i < availableInput.length; i++){
                        if(availableInput[i] == resultInt) found = true;
                    }
                    if(!found) throw new Exception();
                }
            }
            catch(Exception e){
                sentinel = true;
                System.out.println("Your input is incorrect. Try again.");
            }
        }
        while(sentinel);

        return resultInt;
    }

    public static int inputInt(String query){
        return inputInt(query, new int[]{});
    }

    public static String inputDate(String query){

        String result = "";
        boolean sentinel = true;
        while(sentinel){
            sentinel = false;
            try {
                System.out.print(query);
                result = Daycare.scanner.nextLine();

                if(result.charAt(4) != '-' ||
                   result.charAt(7) != '-' ||
                   result.length() != 10 ||
                   Integer.valueOf(result.substring(0, 4)) < 1900 ||
                   Integer.valueOf(result.substring(5, 7)) > 12 ||
                   Integer.valueOf(result.substring(8, 10)) > 31){
                    throw new Exception();
                }

                if(result == "")
                    return null; //If user presses enter without typing anything in, it skips to the next one
            }
            catch(Exception e){
                sentinel = true;
                System.out.println("Your input is incorrect. Make sure you input the date in the YYYY-MM-DD format and try again.");
            }
        }

        return result;
    }

    public static String hash(String input){
        String result = Hashing.sha256()
                .hashString(input, StandardCharsets.UTF_8)
                .toString();

        return result;
    }

    public static boolean isNull(Object o){
        if(o == null){
            errorMessage("Not all necessary information provided.");
            return true;
        }

        return false;
    }

    public static UserAccount logIn(){
        String username = inputString("Username: ");
        String password = inputString("Password: ");

        return Daycare.model.getUserAccountList().findAccount(username, password);
    }

    public static void successMessage(String text){
        View.renderBlock("- Success! -");

        System.out.println(text);

        System.out.println();
        System.out.println("Press Enter to continue...");
        Daycare.scanner.nextLine();
    }

    public static void errorMessage(String text){
        View.renderBlock("- Failure! -");

        System.out.println(text);

        System.out.println();
        System.out.println("Press Enter to continue...");
        Daycare.scanner.nextLine();
    }
}
