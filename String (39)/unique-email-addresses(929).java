// T = O(n)
// S = O(n)
class Solution {
    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for(String email : emails) {
            String[] split = email.split("@");
            StringBuilder sb = new StringBuilder();
            char[] firstPart = split[0].toCharArray();
            for(int j = 0; j < firstPart.length; j++) {
                if(firstPart[j] == '.') continue;
                else if(firstPart[j] == '+') break;
                else sb.append(firstPart[j]);
            }
            sb.append("@");
            sb.append(split[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}