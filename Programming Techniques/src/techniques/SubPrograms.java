package techniques;

public class SubPrograms {

    public static void main(String[] args){

        greeting("Maria");
        greeting();
        greeting("John");

        int total = addition(5, 6);
        System.out.println("5 + 6 = " + total);
        System.out.println("248 + 869 = " + addition(248, 869));

    }

    //Procedure
    // void means no return
    public static void greeting(String name){
        System.out.println("Welcome " + name);
    }
    public static void greeting(){
        System.out.println("Welcome User");
    }

    // Function
    public static int addition(int num1, int num2){
        int total = num1 + num2;
        return total;
    }

}
