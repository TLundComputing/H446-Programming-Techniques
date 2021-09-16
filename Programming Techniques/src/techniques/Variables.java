package techniques;

public class Variables {

    public static void main(String[] args){ //This is the main method
        int age = 26;
        float height = 167.64f; // float is the same a real
        boolean isMale = true;
        char initial = 'T';
        String name = "Mr Lund";
        final double PI = 3.142;

        System.out.println("My age is " + age);
        System.out.printf("My name is %s I stand %.2f cm off the floor\n", name, height);
    }

}
