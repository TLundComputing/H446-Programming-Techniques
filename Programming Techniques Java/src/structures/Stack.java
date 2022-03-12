package structures;

import java.util.ArrayList;

public class Stack<T> {

    private final ArrayList<T> STACK;

    // Constructs the stack as an new empty array list
    public Stack(){
        STACK = new ArrayList<>();
    }

    // Allows items to be added to the stack
    public void push(T item){
        STACK.add(item);
    }

    // Pops the last item in the list off the stack providing that the stack is not empty
    public T pop(){
        T item = null;
        if(!isEmpty()){
            item = STACK.remove(STACK.size() - 1);
        } else {
            System.out.println("Stack is empty null returned");
        }
        return item;
    }

    // Checks if the stack is empty by checking the size of the array list
    public boolean isEmpty(){
        return STACK.size() == 0;
    }

}
