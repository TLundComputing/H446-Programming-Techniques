package classes;

public class Animal {

    private String name;
    private int numberOfLegs;
    private String sound;
    private boolean hasTail;
    private String typeOfAnimal;

    public Animal(String name, int numberOfLegs, String sound, boolean hasTail, String typeOfAnimal){
        this.name = name;
        this.numberOfLegs = numberOfLegs;
        this.sound = sound;
        this.hasTail = hasTail;
        this.typeOfAnimal = typeOfAnimal;
    }

    public void speak(){
        System.out.println(name + " says " + sound);
    }

    public void move(){
        System.out.println(name + " moves one space");
    }

}
