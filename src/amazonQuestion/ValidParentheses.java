package amazonQuestion;

import java.util.Stack;

/**
 * Created by JiahengYu on 29/09/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()){
                if (s.charAt(i) == ')' && stack.pop() == '(') continue;
                else if (s.charAt(i) == ']' && stack.pop() == '[') continue;
                else if (s.charAt(i) == '}' && stack.pop() == '{') continue;
                else
                    return false;
            } else if (stack.isEmpty()){
                return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String args[]) {
        System.out.println(new ValidParentheses().isValid("){"));
    }
}
