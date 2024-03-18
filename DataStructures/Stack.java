package MyJava.DataStructures;

import java.util.NoSuchElementException;

public class Stack{
    private int top = -1;
    private int size = 5;
    private int[] stack = new int[size];

    public void push(int value){
        if(top==(size-1)){
            int[] tempArray = new int[size*2];
            for(int i=0; i<size; i++){
                tempArray[i]=stack[i];
            }
            stack = tempArray;
        }
        stack[++top] = value;
    }

    public int pop(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        return stack[top--];
    }

    public int peek(){
        if(this.isEmpty())
            throw new NoSuchElementException();
        return stack[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }
}