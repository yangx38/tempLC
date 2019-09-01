// T = |V|+|V|*|n| V as equations.length, n as queries' length, 
// S = |V+n|
class Solution {
    Map<String, List<Node>> map = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if(equations.size() != values.length) return null;
        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String first = equation.get(0), second = equation.get(1); double k = values[i];
            if(!map.containsKey(first)) map.put(first, new ArrayList<>());
            map.get(first).add(new Node(second, k));
            if(!map.containsKey(second)) map.put(second, new ArrayList<>());
            map.get(second).add(new Node(first, 1/k));
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < res.length; i++) {
            List<String> query = queries.get(i);
            String x = query.get(0), y = query.get(1);
            res[i] = dfs(x, y, 1, new HashSet<>());
        }
        return res;
    }
    
    private double dfs(String x, String y, double value, Set<String> visited) {
        if(visited.contains(x)) return -1;
        if(!map.containsKey(x)) return -1;

        if(x.equals(y)) return value;
        visited.add(x);
        for(Node next : map.get(x)) {
            String z = next.den;
            if(visited.contains(z)) continue;
            
            double sub = dfs(z, y, value * next.weight, visited);
            if(sub != -1.0) return sub; 
        }
        visited.remove(x);
        return -1;
    }
    
    class Node {
        String den; // destination
        double weight;
        public Node(String den, double weight) {
            this.den = den;
            this.weight = weight;
        }
    }
}