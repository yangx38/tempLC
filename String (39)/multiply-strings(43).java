// T = O(m*n)
// S = O(m+n)
class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.equals("0") || num2.equals("0")) 
            return "0";
        
        int[] res = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1; i >= 0; i--) {
            for(int j = num2.length()-1; j >= 0; j--) {
                int prod = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int d1 = i+j, d2 = i+j+1;
                prod += res[d2];
                res[d1] += prod/10;
                res[d2] = prod%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++) {
            if(sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }
}