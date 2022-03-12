package classes;

public class Cat extends Animal{

    private String name;

    public Cat(String name){
        super(name, 4, "Meow", true, "Cat");
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + " moves 2 spaces");
    }
}
