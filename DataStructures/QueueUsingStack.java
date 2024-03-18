package MyJava.DataStructures;

import java.util.Stack;
public class QueueUsingStack {
    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();

    public void enqueue(int value){
        st1.push(value);
    }

    public int dequeue(){
        if(st2.isEmpty()){
            if(st1.isEmpty())
                throw new IllegalStateException();
            while(!st1.isEmpty())
                st2.push(st1.pop());
        }

        return st2.pop();
    }
    
}
