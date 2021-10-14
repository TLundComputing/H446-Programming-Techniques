package techniques;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysAndLists {

    public static void main(String[] args){
        // Array
        String[] shoppingList = {"Fruit", "Veg", "Frozen Food", "Drinks", "Bread"};
        System.out.println(Arrays.toString(shoppingList));
        shoppingList[4] = "Cereal";
        System.out.println(Arrays.toString(shoppingList));

        int[] numbers = new int[10];
        for(int i = 0; i <= 9; i++){
            numbers[i] = i + 1;
        }
        System.out.println(Arrays.toString(numbers));

        // List
        ArrayList<String> names = new ArrayList<>();
        names.add("Gerald");
        names.add("Laura");
        names.add("Mildrid");
        System.out.println(names.get(1));
        names.remove(0);
        System.out.println(Arrays.toString(names.toArray()));
    }

}
