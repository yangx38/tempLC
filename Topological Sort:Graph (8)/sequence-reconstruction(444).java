// T = O(|V|+|E|)
// S = O(|V|+|E|)
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for(List<Integer> seq : seqs) {
            if(seq.size() == 1) {
                if(!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                    degree.put(seq.get(0), 0);
                }
            } else {
                for(int i = 1; i < seq.size(); i++) {
                    int cur = seq.get(i);
                    int pre = seq.get(i-1);
                    if(!map.containsKey(cur)) {
                        map.put(cur, new HashSet<>());
                        degree.put(cur, 0);
                    }
                    if(!map.containsKey(pre)) {
                        map.put(pre, new HashSet<>());
                        degree.put(pre, 0);
                    }
                    if(map.get(pre).add(cur)) {
                        degree.put(cur, degree.get(cur)+1);
                    }
                }
            }
        }
        if(map.size() != org.length) return false;
        Queue<Integer> queue = new LinkedList<>();
        for(Integer d : degree.keySet()) {
            if(degree.get(d) == 0) queue.offer(d); 
        } 
        
        int index = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(size > 1) return false;
            int cur = queue.poll();
            if(org[index++] != cur) return false;
            for(Integer cc : map.get(cur)) {
                degree.put(cc, degree.get(cc)-1);
                if(degree.get(cc) == 0) queue.offer(cc);
            }
        }
        return index == org.length;
    }
}