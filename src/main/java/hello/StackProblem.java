package hello;

import java.util.Stack;

public class StackProblem {
    public boolean isTrue (String s){
        Stack<Character> st = new Stack <Character>();
        //Get the string and keep pushing characters
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'a')
            st.push(s.charAt(i));
            else {
                if (s.charAt(i) == 'b'){
                    if (st.empty() || st.pop() != 'a'){
                        return false;
                    }
                }

            }
        }
        if (st.empty())
        return true;
        else
            return false;

    }
    public static void main (String [] v){
        StackProblem sp = new StackProblem();
        boolean ist = sp.isTrue("aabb");
        ist = sp.isTrue("abab");
        ist = sp.isTrue("aba");

    }
}
