package io.github.tlundcomputing.cardgamejava;

public class Stack<T> {
    
    private final T[] stack;
    private int pointer;
    private final int maxSize;
    
    public Stack(int size){
        stack = (T[]) new Object[size];
        pointer = -1;
        maxSize = size;
    }
    
    public Stack(){
        stack = (T[]) new Object[100];
        pointer = -1;
        maxSize = 100;
    }
    
    public boolean isEmpty(){
        return pointer == -1;
    }
    
    public boolean isFull(){
        return pointer == maxSize - 1;
    }
    
    public void push(T item){
        if(!isFull()){
            pointer += 1;
            stack[pointer] = item;
        } else {
            System.out.println("Stack is Full!");
        }
    }
    
    public T pop(){
        T value = null;
        if(!isEmpty()){
            value = stack[pointer];
            pointer -= 1;
        } else {
            System.out.println("Stack is empty!");
        }
        return value;
    }
    
}
