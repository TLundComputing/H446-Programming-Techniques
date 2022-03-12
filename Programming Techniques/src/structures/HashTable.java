package structures;

public class HashTable<T> {

    // Declare Variables
    private final int size;
    private final int stepFactor = 3;
    private final T[] table;
    private int items;

    // Constructor
    public HashTable(int theSize){
        size = theSize;
        table = (T[]) new Object[size];
        items = 0;
    }

    // Adding an item
    public void addItem(T item){
        if(isFull()){
            System.out.println("Table is full, item can't be added");
        } else {
            int index = (Integer) item % size;
            if(table[index] == null){
                table[index] = item;
            } else {
                while(table[index] != null){
                    index = (index + stepFactor) % size;
                    if(table[index] == null){
                        table[index] = item;
                        break;
                    }
                }
            }
            items++;
        }
    }

    // Removing an item
    public boolean removeItem(T item){
        boolean removed = false;
        if(isEmpty()){
            System.out.println("Table is empty, item can't be removed");
        } else {
            int index = (Integer) item % size;
            if(table[index] == item){
                items--;
                removed = true;
                table[index] = null;
            } else {
                while(table[index] != item && table[index] != null){
                    index = (index + stepFactor) % size;
                    if(table[index] == item){
                        items--;
                        removed = true;
                        table[index] = null;
                        break;
                    }
                }
            }
        }
        return removed;
    }

    public boolean isFull(){
        return items == size;
    }

    public boolean isEmpty(){
        return items == 0;
    }

}
