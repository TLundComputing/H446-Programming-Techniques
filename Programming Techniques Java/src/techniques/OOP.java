package techniques;

import classes.*;

public class OOP {

    public static void main(String[] args){

        Animal garfield = new Animal("Garfield", 4, "I hate Mondays",
                true, "Cat");

        garfield.speak();

        Animal mickey = new Animal("Mickey Mouse", 2, "Welcome to the clubhouse",
                true, "Mouse");

        mickey.speak();

        Cat whiskers = new Cat("Whiskers");
        whiskers.speak();

        garfield.move();
        mickey.move();
        whiskers.move();
    }

}
