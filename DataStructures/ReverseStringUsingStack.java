package MyJava.DataStructures;

import java.util.Stack;

public class ReverseStringUsingStack {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String str = "Prathamesh";
        for(int i=0; i<str.length(); i++)
            stack.push(str.charAt(i));
        String revStr="";
        while(!stack.empty())
            revStr += stack.pop();

        System.out.println(revStr);
    } 
}
