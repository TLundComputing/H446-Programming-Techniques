package techniques;

public class Selection {

    public static void main(String[] args){
        int speed = 71;
        int day = 72;
        String answer = "Paris";

        if(answer.equalsIgnoreCase("Paris")){
            System.out.println("Correct Answer");
        } else {
            System.out.println("Incorrect");
        }

        if(speed >= 77){
            System.out.println("Issue Speeding Ticket");
        } else if(speed >= 70){
            System.out.println("Issue Speed Warning");
        }
        else {
            System.out.println("No Action");
        }

        switch (day){
            case 1: System.out.println("Monday");break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday"); break;
            case 5: System.out.println("Friday"); break;
            case 6: System.out.println("Saturday"); break;
            case 7: System.out.println("Sunday"); break;
            default: System.out.println("Not a day!");
        }

    }

}
