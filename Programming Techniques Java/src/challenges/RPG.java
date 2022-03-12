package challenges;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * class RPG for creating characters
 */
public class RPG {

    /**
     * main method
     * Used to start the menu system for Planet FightCraft
     * @param args
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input;
        ArrayList<Character> characters = new ArrayList<>();
        boolean playing = true;
        while(playing){
            System.out.println("Planet of Fightcraft - menu\n" +
                    "1 - Generate Team\n" +
                    "2 - View Team\n" +
                    "3 - Edit Team\n" +
                    "4 - Save Team\n" +
                    "5 - Import Team\n" +
                    "4 - Exit");
            System.out.print("> ");
            input = scan.nextLine();
            switch(input){
                case "1": characters = generatePlayers(10); System.out.println("Team created"); break;
                case "2":
                    if(characters.size() > 0){
                        printTeam(characters);
                    } else {
                        System.out.println("You do not have a team yet");
                    }
                    break;
                case "3": characters = editTeam(characters, scan); break;
                default: System.out.println("Goodbye"); playing = false;
            }
        }

    }

    /**
     * generate Players
     * Generates a list of 10 characters.
     * @param amountOfPlayers
     * @return listOfCharacters
     */
    public static ArrayList<Character> generatePlayers(int amountOfPlayers){
        String[] syllables = {"en", "da", "fu", "el", "kar", "tuk"};
        ArrayList<Character> characters = new ArrayList<>();
        Random gen = new Random();
        for(int i = 1; i <= amountOfPlayers; i++){
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
        return characters;
    }

    public static void printTeam(ArrayList<Character> characters){
        System.out.println("Your characters:");
        for(Character c : characters){
            System.out.println();
            c.describe();
        }
    }

    public static ArrayList<Character> editTeam(ArrayList<Character> characters, Scanner scan){
        boolean editing = true;
        while(editing){
            System.out.printf("You have %d members in your team\n", characters.size());
            System.out.println("What do you want to do?\n" +
                    "1 - Delete a team member\n" +
                    "2 - Add a team member\n" +
                    "3 - Go back");
            String input = scan.nextLine();
            if(input.equalsIgnoreCase("1")){
                System.out.println("Character summery and position");
                for(int i = 1; i < characters.size(); i++){
                    System.out.println(i + " - " + characters.get(i-1).getSummery());
                }
                System.out.println("Enter the number of the team member you want to remove");
                input = scan.nextLine();
                try{
                    int pos = Integer.parseInt(input);
                    characters.remove(pos - 1);
                    System.out.println("Character removed");
                } catch(NumberFormatException e){
                    System.out.println("You did not enter a number - returning to menu");
                }
            } else if(input.equalsIgnoreCase("2")){
                if(characters.size() == 10){
                    System.out.println("Your team is full!");
                } else {
                    ArrayList<Character> append = generatePlayers(10 - characters.size());
                    characters.addAll(append);
                }
            } else{
                editing = false;
            }
        }
        return characters;
    }
}
