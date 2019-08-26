// T = O(n)
// S = O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        // 注意顺序
        for(String token : tokens) {
            if(token.equals("+")) {
                stack.push(stack.pop()+stack.pop());
            } else if(token.equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second-first);
            } else if(token.equals("*")) {
                stack.push(stack.pop()*stack.pop());
            } else if(token.equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second/first);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}