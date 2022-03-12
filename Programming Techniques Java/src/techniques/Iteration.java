package techniques;

public class Iteration {

    public static void main(String[] args){
        String[] items = {"Apple", "Banana", "Beans", "Bacon", "Bread"};

        // For loops - Count controlled
        for(int x = 1; x < 11; x++){
            System.out.println("x is at " + x);
        }
        System.out.println("My shopping trolly contains:");
        for(String item : items){
            System.out.println(item);
        }

        // While loop - condition controlled
        int counter = 1;
        while(counter < 11){
            System.out.println("counter is at " + counter);
            counter++;
        }

        do{
            System.out.println("Counter is at " + counter);
            counter--;
        } while(counter > 0);
    }

}
