package Controller;

import java.util.Scanner;

public abstract class Controller {
    public String inputString(String query, Scanner scanner){

        String result = "";
        boolean sentinel;
        do{
            sentinel = false;
            try {
                System.out.print(query);
                result = scanner.next();
            }
            catch(Exception e){
                sentinel = true;
                System.out.println("Your input is incorrect. Try again.");
            }
        }
        while(sentinel);

        return result;
    }

    public int inputInt(String query, Scanner scanner){

        int result = -1;
        boolean sentinel;
        do{
            sentinel = false;
            try {
                System.out.print(query);
                result = scanner.nextInt();
            }
            catch(Exception e){
                sentinel = true;
                System.out.println("Your input is incorrect. Try again.");
            }
        }
        while(sentinel);

        return result;
    }

    public String inputDate(String query, Scanner scanner){

        String result = "";
        boolean sentinel = true;
        while(sentinel){
            sentinel = false;
            try {
                System.out.print(query);
                result = scanner.next();

                if(result.charAt(4) == '-' &&
                   result.charAt(7) == '-' &&
                   result.length() == 10 &&
                   Integer.valueOf(result.substring(0, 3)) > 1900 &&
                   Integer.valueOf(result.substring(5, 6)) < 13 &&
                   Integer.valueOf(result.substring(8, 9)) < 32){
                    sentinel = true;
                }
            }
            catch(Exception e){
                sentinel = true;
                System.out.println("Your input is incorrect. Make sure you input the date in the YYYY-MM-DD format and try again.");
            }
        }

        return result;
    }
}
