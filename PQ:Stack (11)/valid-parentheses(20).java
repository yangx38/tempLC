// T = O(n)
// S = O(n)
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        char[] sc = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(sc[i] == '(') stack.push(')');
            else if(sc[i] == '[') stack.push(']');
            else if(sc[i] == '{') stack.push('}');
            else {
                if(stack.isEmpty()) return false;
                else if(stack.pop() != sc[i]) return false;
            }
        }
        return stack.isEmpty();
    }
}