class Solution {
    // modify 77 Combinations
    public Set<List<Integer>> combine(int[] n, int k) {
        Set<List<Integer>> retSet = new HashSet<>();
        if(n.length <= 0) return retSet;

        if(k <= 1) {
            for(int i = 0; i < n.length; i++) {
                List<Integer> retList = new ArrayList<>();
                retList.add(n[i]);
                retSet.add(retList);
            }
            return retSet;
        }
        
        Set<List<Integer>> retPrev = combine(n, k - 1);
        
        for(List<Integer> prev : retPrev) {
            for(int j = 0; j < n.length; j++) {
                if(prev.contains(n[j])) continue;
                List<Integer> newList = new ArrayList<>(prev);
                newList.add(n[j]);
                Collections.sort(newList); 
                retSet.add(newList);
            }
        }
                
        return retSet;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> retSet = new HashSet<>();
        retSet.add(new ArrayList<>()); // empty set
        
        for(int i = 1; i <= nums.length; i++) {
            retSet.addAll(combine(nums, i));
        }
        
        return new ArrayList<>(retSet);
    }
}
