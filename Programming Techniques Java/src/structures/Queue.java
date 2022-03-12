package structures;

// T data type means any type of data during queue initialisation
public class Queue<T>{

    // Attributes
    private int rear, front, size;
    private final int MAXSIZE;
    private final T[] QUEUE;

    // Constructor
    public Queue(int theSize){
        front = 0;
        rear = -1;
        size = 0;
        MAXSIZE = theSize;
        QUEUE = (T[]) new Object[MAXSIZE];
    }

    // isEmpty, isFull, enqueue, dequeue

    //isEmpty
    public boolean isEmpty(){
        return size == 0;
    }

    //isFull
    public boolean isFull(){
        return size == MAXSIZE;
    }

    //enqueue
    public void enqueue(T item){
        if(isFull()){
            System.out.println("The queue is full, item not added");
        } else {
            rear = (rear + 1) % MAXSIZE;
            QUEUE[rear] = item;
            size += 1;
        }
    }

    //dequeue
    public T dequeue(){
        T item = null;
        if(isEmpty()){
            System.out.println("Queue is empty, null returned");
        } else {
            item = QUEUE[front];
            front = (front + 1) % MAXSIZE;
            size -= 1;
        }
        return item;
    }

}
