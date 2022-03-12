package challenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ArithmeticTestSolutionIfs {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int question = 1;
        int points = 0;
        Random generator = new Random();
        String name, className;

        System.out.print("Welcome to the Arithmetic Test\nEnter your name: ");
        name = scan.nextLine();
        System.out.print("Enter your class: ");
        className = scan.nextLine();

        while(question < 11){
            int num1 = generator.nextInt(12) + 1;
            int num2 = generator.nextInt(12) + 1;
            int operator = generator.nextInt(4);
            int total;
            String sum;
            int guess;
            if(operator == 0){
                sum = num1 + " + " + num2 + " = ";
                total = num1 + num2 ;
            } else if(operator == 1){
                sum = num1 + " * " + num2 + " = ";
                total = num1 * num2 ;
            } else if(operator == 2){
                if(num1 > num2){
                    sum = num1 + " - " + num2 + " = ";
                    total = num1 - num2;
                } else {
                    sum = num2 + " - " + num1 + " = ";
                    total = num2 - num1;
                }
            } else {
                if(num1 > num2){
                    sum = "Enter your answer to the closest whole number rounded down.\n" +
                            num1 + " / " + num2 + " = ";
                    total = Math.floorDiv(num1, num2);
                } else {
                    sum = "Enter your answer to the closest whole number rounded down.\n" +
                            num2 + " / " + num1 + " = ";
                    total = Math.floorDiv(num2, num1);
                }
            }

            while (true){
                System.out.println("\n\nQuestion " + question);
                System.out.print(sum);
                String rawInput = scan.nextLine();
                try{
                    guess = Integer.parseInt(rawInput);
                    break;
                } catch(NumberFormatException e){
                    System.out.println("You did not enter a number try again!");
                }
            }

            if(total == guess){
                System.out.println("Well done!");
                points += 1;
            } else {
                System.out.println("Nice try but that answer is not correct");
            }

            question++;
        }

        System.out.println("\n\nGame Over your final score is: " + points + " out of 10");

        try {
            FileWriter file = new FileWriter("resources/scores.txt", true);
            BufferedWriter buff = new BufferedWriter(file);
            buff.write(name + ":" + className + ":" + points + "\n");
            buff.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

}
