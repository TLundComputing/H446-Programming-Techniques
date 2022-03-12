package structures;

public class Main {

    public static void main(String[] args){

        /*Queue<String> busses = new Queue<>(5);

        busses.enqueue("Sheffield");
        busses.enqueue("York");
        busses.enqueue("Leeds");
        busses.enqueue("Bristol");
        busses.enqueue("Cardiff");
        busses.dequeue();
        busses.dequeue();
        busses.enqueue("Plymouth");*/

        /*Stack<String> characters = new Stack<>();
        characters.push("L");
        characters.push("U");
        characters.push("N");
        characters.pop();
        characters.push("D");*/

        HashTable<Integer> numbers = new HashTable<>(100);
        numbers.addItem(47);
        numbers.addItem(247);
        numbers.removeItem(47);

        System.out.println("End of program");

    }

}
