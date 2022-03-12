package challenges;

import java.util.*;

public class GameOfChance {

    public static void main(String[] args){
        int bet, winner, multiplier;
        winner = generateNumber();
        System.out.println("Text Number is: " + winner);
        while(true){
            try{
                bet = Integer.parseInt(getInput("Enter a number"));
                break;
            } catch(NumberFormatException e){
                System.out.println("You did nto enter a number, try again");
            }
        }

        if(bet == winner){
            multiplier = findMultiplier(bet);
            System.out.println("Well done! you scored x" + multiplier);
        } else {
            System.out.println("you lost! the winning number was: " + winner);
        }
    }

    public static int generateNumber(){
        Random gen = new Random();
        return gen.nextInt(31);
    }

    public static int findMultiplier(int num){
        int multiplier = 1;
        boolean isPrime = true;

        if(num % 2 == 0){
            multiplier *= 2;
        }
        if(num % 10 == 0){
            multiplier *= 3;
        }
        if(num < 5){
            multiplier *= 2;
        }

        int count = 2;
        while((isPrime) && count < num){
            if(num % count == 0){
                isPrime = false;
            }
            count += 1;
        }

        if(isPrime){
            multiplier *= 5;
        }

        return multiplier;
    }

    public static String getInput(String message){
        Scanner scan = new Scanner(System.in);
        System.out.print(message + ": ");
        String input = scan.nextLine();
        return input;
    }

    public static String getInput(){
        Scanner scan = new Scanner(System.in);
        System.out.print("> ");
        String input = scan.nextLine();
        return input;
    }

}
