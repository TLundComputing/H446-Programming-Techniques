package challenges;

import java.util.ArrayList;
import java.util.Random;

public class RPG {

    public static void main(String[] args){
        String[] syllables = {"en", "da", "fu", "el", "kar", "tuk"};
        ArrayList<Character> characters = new ArrayList<>();
        Random gen = new Random();
        for(int i = 1; i <= 10; i++){
            String name = syllables[gen.nextInt(5)] + "-" + syllables[gen.nextInt(5)] + "-" + syllables[gen.nextInt(5)];
            int character = gen.nextInt(5);
            switch(character){
                case 0: characters.add(new Barbarian(name)); break;
                case 1: characters.add(new Elf(name)); break;
                case 2: characters.add(new Wizard(name)); break;
                case 3: characters.add(new Dragon(name)); break;
                case 4: characters.add(new Knight(name)); break;
            }
        }

        System.out.println("Your characters:");
        for(Character c : characters){
            System.out.println();
            c.describe();
        }
    }

}
