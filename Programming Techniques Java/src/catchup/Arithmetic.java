package catchup;

import java.util.Random;
import java.util.Scanner;

public class Arithmetic {

    public static void main(String[] args){
        // Init variables
        Scanner input = new Scanner(System.in);
        Random gen = new Random();
        String name;
        int score = 0;
        System.out.print("Enter your name: ");
        name = input.nextLine();

        // 10 Question Loop
        for(int question = 1; question <= 10; question++){
            // Init variables
            String sum, rawGuess;
            int answer, guess;
            int num1 = gen.nextInt(12) + 1; // makes a random number between 1 and 12
            int num2 = gen.nextInt(12) + 1; // makes a random number between 1 and 12
            int operator = gen.nextInt(4); // for plus minus times and divide
            if(operator == 0){
                // Code for my addition
                sum = num1 + " + " + num2 + " = ";
                answer = num1 + num2;
            } else if(operator == 1){
                // Code for subtraction
                if(num1 > num2){
                    sum = num1 + " - " + num2 + " = ";
                    answer = num1 - num2;
                } else {
                    sum = num2 + " - " + num1 + " = ";
                    answer = num2 - num1;
                }
            } else if(operator == 2){
                // Code for multiply
                sum = num1 + " * " + num2 + " = ";
                answer = num1 * num2;
            } else {
                sum = "Please enter your answer to the nearest whole number rounded down\n";
                if(num1 > num2){
                    sum += num1 + " / " + num2 + " = ";
                    answer = Math.floorDiv(num1, num2);
                } else {
                    sum += num2 + " / " + num1 + " = ";
                    answer = Math.floorDiv(num2, num1);
                }
            }

            System.out.println("Question number " + question);
            System.out.print(sum);
            rawGuess = input.nextLine();

            while(true){
                try{
                    guess = Integer.parseInt(rawGuess);
                    break;
                } catch(NumberFormatException e){
                    System.out.println("You did not enter a number, please try again");
                    System.out.println("Question number " + question);
                    System.out.print(sum);
                    rawGuess = input.nextLine();
                }
            }

            if(guess == answer){
                System.out.println("Well Done you got it right!");
                score += 1;
            } else {
                System.out.println("Nice try, but it is incorrect");
            }
        }

        System.out.println("Well done " + name + " you scored " + score + " out of 10");
    }

}
