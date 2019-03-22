class Solution {
    // Failed due to time limit exceeded
    public List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> retSet = new HashSet<>();
        if(n <= 0) return new ArrayList<>(retSet);

        if(k <= 1) {
            for(int i = 1; i <= n; i++) {
                List<Integer> retList = new ArrayList<>();
                retList.add(i);
                retSet.add(retList);
            }
            return new ArrayList<>(retSet);
        }
        
        List<List<Integer>> retPrev = combine(n, k - 1);
        
        for(int i = 0; i < retPrev.size(); i++) {
            List<Integer> prev = retPrev.get(i);
            for(int j = 1; j <= n; j++) {
                if(prev.contains(j)) continue;
                List<Integer> newList = new ArrayList<>(prev);
                newList.add(j);
                Collections.sort(newList); 
                retSet.add(newList);
            }
        }
                
        return new ArrayList<>(retSet);
    }
}
