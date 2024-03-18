package MyJava.DataStructures;

import java.util.Stack;
public class BracketsCheck {
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        String inpString = "(((((((((())))))";
        boolean isValid=true;
        for (char ch : inpString.toCharArray()) {
            if(ch=='(' || ch=='{' || ch=='{' || ch=='<')
                st.push(ch);
            if(ch==')'){
                if(!st.empty() && st.peek()=='(')
                    st.pop();
                else{
                    isValid=false;
                    break;
                }
            }
            if(ch=='}'){
                if(!st.empty() && st.peek()=='(')
                    st.pop();
                else{
                    isValid=false;
                    break;
                }
            }
            if(ch=='>'){
                if(!st.empty() && st.peek()=='(')
                    st.pop();
                else{
                    isValid=false;
                    break;
                }
            }
            if(ch==']'){
                if(!st.empty() && st.peek()=='(')
                    st.pop();
                else{
                    isValid=false;
                    break;
                }
            }
        }
        if(st.empty())
            System.out.println(isValid);
        else
            System.out.println(false);
    }
}
