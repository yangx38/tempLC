// T = O(n)
// S = O(n)
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Stack<Integer> cntStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String res = "";
        char[] sc = s.toCharArray();
        int i = 0, n = sc.length; 
        while(i < n) {
            char c = sc[i];
            if(Character.isLetter(c)) {
                res += c;
                i++;
            }
            else if(Character.isDigit(c)) {
                int cnt = 0;
                while(i < n && sc[i] >= '0' && sc[i] <= '9') cnt = cnt*10+(sc[i++]-'0');
                cntStack.push(cnt);
            }
            else if(c == '[') {
                strStack.push(res);
                res = "";
                i++;
            }
            else {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int times = cntStack.pop();
                for(int j = 0; j < times; j++) sb.append(res);
                res = sb.toString();
                i++;
            }
        }
        return res;
    }
}