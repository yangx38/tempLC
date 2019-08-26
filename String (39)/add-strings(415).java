// T = O(m+n)
// S = O(n)
class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length() == 0 || num1.equals("0")) return num2;
        if(num2.length() == 0 || num2.equals("0")) return num1;
        int i = num1.length()-1, j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry == 1) {
            int d1 = i >= 0 ? num1.charAt(i--)-'0' : 0;
            int d2 = j >= 0 ? num2.charAt(j--)-'0' : 0;
            carry += d1+d2;
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}