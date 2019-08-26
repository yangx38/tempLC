// T = O(n)
// S = O(n)
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        if(text == null || text.length() == 0) return new String[0];
        List<String> res = new ArrayList<>();
        String[] tc = text.split("\\s+");
        if(tc.length < 2) return new String[0];
        for(int i = 1; i < tc.length-1; i++) {
            if(tc[i-1].equals(first) && tc[i].equals(second)) {
                res.add(tc[i+1]);
            }
        }
        
        String[] resArr = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}