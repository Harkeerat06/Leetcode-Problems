import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> openBrackets = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                // Store the index of the open parenthesis
                openBrackets.push(i);
            } else if (sb.charAt(i) == ')') {
                // Get the matching open parenthesis index
                int start = openBrackets.pop();
                // Reverse the substring between the matching pair
                reverse(sb, start + 1, i - 1);
            }
        }
        
        // Build the final string by removing all parentheses
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c != '(' && c != ')') {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}
