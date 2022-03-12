package techniques;

import java.io.*;

public class Writing {

    public static void main(String[] args){
        try{
            FileWriter file = new FileWriter("resources/stats.txt");
            BufferedWriter buff = new BufferedWriter(file);
            buff.write("People who understand java: 7\n");
            buff.write("People who kinda get it: 11\n");
            buff.write("People who don't understand java: 4\n");
            buff.close();
            file.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
