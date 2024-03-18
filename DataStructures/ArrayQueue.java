package MyJava.DataStructures;

import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;
    private int front=0;
    private int back=0;
    private int count=0;

    public ArrayQueue(int size){
        queue = new int[size];
    }

    public void enqueue(int value){
        if(this.isFull())
            throw new IllegalStateException();
        queue[back] = value;
        back = (back+1) % queue.length;
        count++;
    }

    public int dequeue(){
        if(this.isEmpty())
            throw new IllegalStateException();
        var item = queue[front];
        queue[front]=0;
        front = (front + 1) % queue.length;
        count--;
        return item;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public boolean isFull(){
        return count == queue.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(queue);
    }
}
