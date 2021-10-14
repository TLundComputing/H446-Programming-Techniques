package challenges;

import java.util.Random;
import java.util.Scanner;

public class ArithmeticTest {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();

        int question = 1;
        int score = 0;

        while(question < 11){
            int operator = generator.nextInt(4);
            int num1 = generator.nextInt(12) + 1;
            int num2 = generator.nextInt(12) + 1;
            String sum = "";
            int answer = 0;

            switch (operator){
                case 0:
                    sum = num1 + " + " + num2 + " = ";
                    answer = num1 + num2;
                    break;
                case 1:
                    sum = num1 + " * " + num2 + " = ";
                    answer = num1 * num2;
                    break;
                case 2:
                    if(num1 > num2){
                        sum = num1 + " - " + num2 + " = ";
                        answer = num1 - num2;
                    } else {
                        sum = num2 + " - " + num1 + " = ";
                        answer = num2 - num1;
                    }
                    break;
                case 3:
                    System.out.println("Enter your answer to the nearest whole number rounded down");
                    if(num1 > num2){
                        sum = num1 + " / " + num2 + " = ";
                        answer = Math.floorDiv(num1, num2);
                    } else {
                        sum = num2 + " / " + num1 + " = ";
                        answer = Math.floorDiv(num2, num1);
                    }
                    break;
                default:
                    sum = "This questions is broken the answer is -1 ";
                    answer = -1;
            }

            System.out.println("Question Number " + question);
            System.out.print(sum);
            String guess = scan.nextLine();

            System.out.println("You entered: " + guess + "\nThe answer was: " + answer);
            System.out.printf("You entered %s\nThe answer was %d\n", guess, answer);

            question++;
        }
    }
}
