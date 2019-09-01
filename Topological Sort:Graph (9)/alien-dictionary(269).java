// T = O(|V|+|E|) = O(n*k + n*k) = O(n*k) n as # of words, k as ave leng per word
// S = O(n) = O(26)    
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        Map<Character, Integer> degree = buildDegree(graph);
        return topo(graph, degree);
    }
    
    private Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        // V
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                if(!graph.containsKey(word.charAt(i))) {
                    graph.put(word.charAt(i), new HashSet<>());
                }
            }
        }
        // E
        for(int i = 0; i <= words.length-2; i++) {
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[i+1].toCharArray();
            int k = 0;
            while(k < word1.length && k < word2.length) {
                if(word1[k] != word2[k]) {
                    graph.get(word1[k]).add(word2[k]);
                    break;
                }
                k++;
            }
        }
        return graph;
    }

    private Map<Character, Integer> buildDegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> degree = new HashMap<>();
        for(Character c : graph.keySet()) {
            degree.put(c, 0);
        }
        
        for(Character c : graph.keySet()) {
            for(Character cChildren : graph.get(c)) {
                degree.put(cChildren, degree.get(cChildren)+1);
            }
        }
        return degree;
    }
    
    private String topo(Map<Character, Set<Character>> graph, Map<Character, Integer> degree) {
        Queue<Character> queue = new LinkedList<>();
        for(Character c : degree.keySet()) {
            if(degree.get(c) == 0) queue.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Character cur = queue.poll();
            sb.append(cur);
            for(Character ne : graph.get(cur)) {
                degree.put(ne, degree.get(ne)-1);
                if(degree.get(ne) == 0) queue.offer(ne);
            }
        }
        return sb.length() == degree.size() ? sb.toString() : "";
    }
}