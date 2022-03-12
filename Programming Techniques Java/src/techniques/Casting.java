package techniques;

import java.util.Scanner;

public class Casting {

    public static void main(String[] args){

        // Allows the application to look at things
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = scan.nextLine();
        try{
            int number = Integer.parseInt(input);
            System.out.println("You entered the number " + number);
        } catch(NumberFormatException e){
            System.out.println("Error - You did not enter a number you entered " + input);
        }


    }

}
