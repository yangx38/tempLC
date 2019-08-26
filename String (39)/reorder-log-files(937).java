// T = O(nlogn)
// S = O(n)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0) return new String[0];
        List<String> digits = new ArrayList<>();
        List<Log> letters = new ArrayList<>();
        for(String log : logs) {
            int firstSpa = log.indexOf(" ");
            char c = log.charAt(firstSpa+1);
            if(Character.isDigit(c)) digits.add(log);
            else {
                String id = log.substring(0, firstSpa);
                String words = log.substring(firstSpa+1);
                letters.add(new Log(id, words));
            }
        }
        // sort letters; digit 不用管
        Collections.sort(letters, (a, b)->{
            int comp = a.words.compareTo(b.words);
            if(comp == 0) return a.id.compareTo(b.id);
            return comp;
        });
        List<String> res = new ArrayList<>();
        for(Log letter : letters) {
            res.add(letter.id + " " + letter.words);
        }
        res.addAll(digits);
        return res.toArray(new String[res.size()]);
    }
    
    class Log {
        String id, words;
        public Log(String id, String words) {
            this.id = id;
            this.words = words;
        }
    }
}