package MyJava.DataStructures;
import java.util.*;

public class ReverseQueue{
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>(10);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        var reversed = reverse(queue);
        System.out.println(reversed);
    }

    public static Queue<Integer> reverse(Queue<Integer> queue){
        Stack stack = new Stack();
        while(!queue.isEmpty()){
            int front = queue.remove();
            stack.push(front);
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        return queue;
    }
}