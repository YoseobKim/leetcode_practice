class Solution {
    private Map<String, Set<Set<Integer>>> memo = new HashMap<>();
    
    private Set<Set<Integer>> combinationSum3Helper(int k, int n) {
        Set<Set<Integer>> ret = new HashSet<>();
        String key = k + ":" + n;
        if(memo.containsKey(key)) return memo.get(key);
        if(k == 0) return ret;
        if(n <= 0) return ret;
        if(k == 1) {
            if(n <= 9 && n > 0) {
                Set<Integer> arr = new HashSet<>();
                arr.add(n);
                ret.add(arr);
                memo.put(key, ret);
                return ret;
            } else {
                return ret;
            }
        }
        
        for(int i = 1; i <= 9; i++) {
            int target = n - i;
            Set<Set<Integer>> next = combinationSum3Helper(k - 1, target);
            for(Set<Integer> res : next) {
                Set<Integer> copy = new HashSet<>(res);
                copy.add(i);
                if(copy.size() == k) {
                    ret.add(copy);
                }
            }
        }
        memo.put(key, ret);
        return ret;
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<Set<Integer>> retFromHelper = combinationSum3Helper(k, n);
        List<List<Integer>> ret = new ArrayList<>(0);
        for(Set<Integer> res : retFromHelper) {
            ret.add(new ArrayList<>(res));
        }
        
        return ret;
    }
}
