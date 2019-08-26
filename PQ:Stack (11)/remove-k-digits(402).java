// T = O(n)
// S = O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        char[] nc = num.toCharArray();
        for(int i = 0; i < nc.length; i++) {
            while(k > 0 && !stack.isEmpty() && stack.peek() > nc[i]) {
                stack.pop(); // 不要这位了
                k--;
            }
            stack.push(nc[i]);
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}