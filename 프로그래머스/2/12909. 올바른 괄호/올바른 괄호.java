import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack <Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') st.push('(');
            else {
                if (st.isEmpty() == true) answer = false;
                else st.pop();
            }
        }
        
        if (st.isEmpty() == false) {
            answer = false;
        }

        return answer;
    }
}