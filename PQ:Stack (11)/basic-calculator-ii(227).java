// T = O(n)
// S = O(n)
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim().replaceAll(" ", ""); // this step T = O(n), S = O(1)
        char[] sc = s.toCharArray();
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = sc.length;
        while(i < n) {
            int cur = 0;
            while(i < n && sc[i] >= '0' && sc[i] <= '9') cur = cur*10+(sc[i++]-'0');
            
            if(sign == '+') stack.push(cur);
            else if(sign == '-') stack.push(-cur);
            else if(sign == '*') stack.push(stack.pop() * cur);
            else stack.push(stack.pop() / cur);
            if(i < n) sign = sc[i++];            
        }
        
        int res = 0;
        for(int sta : stack) res += sta;
        return res;
    }
}

// T = O(n)
// S = O(1)
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim().replaceAll(" ", "");
        char[] sc = s.toCharArray();
        char sign = '+';
        int pre = 0, res = 0;
        int i = 0, n = sc.length; 
        while(i < n) {
            int cur = 0;
            while(i < n && sc[i] >= '0' && sc[i] <= '9') cur = cur*10+(sc[i++]-'0');
            if(sign == '+') {
                res += pre;
                pre = cur;
            } 
            else if(sign == '-') {
                res += pre;
                pre = -cur;
            }
            else if(sign == '*') pre *= cur;
            else pre /= cur;
            if(i < n) sign = sc[i++];
        }
        return pre+res;
    }
}