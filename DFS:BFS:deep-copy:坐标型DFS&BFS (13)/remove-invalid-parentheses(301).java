// count how many ( && ) to delete
// helper(s, pos, L, R) w/ pos 记录的是上一个删的括号位置; 从它后面找
	// invalid case
	// valid case 
	// explore
		// for i : pos ~ n
			// if s[i] == s[i-1]
			// if ) && R > 0 - helper(substring)
			// if ( && L > 0 - helper(substring)

// 递归深度: L+R
// T = 2^(L+R)
// S = (L+R)*(L+R) 层数*每层存一个copy (substring的S是O(n))

class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> removeInvalidParentheses(String s) {
        if(s == null) return new ArrayList<>();
        int[] LR = count(s.toCharArray());
        int L = LR[0], R = LR[1];
        helper(s, 0, L, R);
        return res;
    }
    
    private int[] count(char[] sc) {
        int L = 0, R = 0;
        for(int i = 0; i < sc.length; i++) {
            if(sc[i] == ')') {
                if(L <= 0) R++;
                else L--;
            } else if(sc[i] == '(') {
                L++;
            }
        }
        return new int[]{L, R};
    }
    
    private void helper(String s, int pos, int L, int R) {
        if(L < 0 || R < 0) return;
        if(L == 0 && R == 0) {
            if(isValid(s)) res.add(s);
            return;
        }
        char[] sc = s.toCharArray();
        for(int i = pos; i < s.length(); i++) {
            if(i > pos && sc[i] == sc[i-1]) continue;
            if(sc[i] == '(' && L > 0) {
                String sub = s.substring(0, i)+s.substring(i+1);
                helper(sub, i, L-1, R);
            }
            if(sc[i] == ')' && R > 0) {
                String sub = s.substring(0, i)+s.substring(i+1);
                helper(sub, i, L, R-1);
            }
        }
    }
    
    private boolean isValid(String s) {
        char[] sc = s.toCharArray();
        int count = 0;
        for(int i = 0; i < sc.length; i++) {
            if(sc[i] == '(') count++;
            else if(sc[i] == ')') count--;
            if(count < 0) return false;
        }
        return true;
    }
}