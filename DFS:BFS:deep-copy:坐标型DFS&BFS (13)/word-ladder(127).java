class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 预处理 + corner case
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0; 
        if(set.contains(beginWord)) set.remove(beginWord);
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res = 0;
        while(!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                for(int j = 0; j < word.length(); j++) {
                    char[] wc = word.toCharArray();
                    for(char k = 'a'; k <= 'z'; k++) {
                        if(wc[j] == k) continue;
                        wc[j] = k;
                        String newWord = new String(wc);
                        if(set.contains(newWord)) {
                            if(newWord.equals(endWord)) return res+1;
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}