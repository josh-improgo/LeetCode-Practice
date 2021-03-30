import java.util.HashMap;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/submissions/
 */
public class ValidParentheses {
    /** Solution 1: Stack w/o HashMap **/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // insert open parenthesis into the stack
        // only pop out of the stack if it is a closed parenthesis and matches

        for ( char c : s.toCharArray() ) {
            if ( isOpenParenthesis(c) ) {
                stack.push(c);
            } else {
                if ( stack.isEmpty() || !isMatchedParenthesis(stack.pop(), c)) return false;
            }
        }
        return stack.isEmpty();

    }

    boolean isOpenParenthesis(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    boolean isMatchedParenthesis(char open, char close) {
        switch (open) {
            case '(':
                return close == ')';
            case '[':
                return close == ']';
            case '{':
                return close == '}';
            default:
                return false;
        }
    }

    /** Solution 2: Stack w/ HashMap Solution **/
    public boolean isValid2(String s) {
        // if (s.length()%2 == 1)
        //     return false;

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) stack.push(c);
            else { // is a closed parenthesis
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (c != map.get(open)) return false;
            }

        }
        return stack.isEmpty();
    }
}
