class Solution {
    // idea is if there is sum combinations for target - array item in the array, the combination will be
    // me + [target - array combination]
    // candidates have no duplication.
    private Set<List<Integer>> combinationSumRecursive(int[] candidates, int target) {
        if(candidates.length == 0) return null;
        Set<List<Integer>> ret = new HashSet<>();

        for(int i = 0; i < candidates.length; i++) {
            int item = candidates[i];

            if(item == target) {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                ret.add(list);
                continue;
            }
            if(item > target) break; 
            // item is bigger than taget? no need to loop more as the array is sorted.
            else {
                int diff = target - item;
                Set<List<Integer>> prev = combinationSumRecursive(candidates, diff);
            
                if(prev == null || prev.isEmpty()) continue;
                for(List<Integer> list : prev) {
                    list.add(item);
                    Collections.sort(list);
                    ret.add(list);
                }
            }
        }
        return ret;
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();

        if(candidates.length <= 0) return ret;
        else if(candidates.length == 1) {
            if(candidates[0] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                ret.add(list);
                return ret;
            }
        }
        
        Arrays.sort(candidates); // for better judgement, sort the array first.
        // The solution set must not contain duplicate combinations.
        Set<List<Integer>> retSet = combinationSumRecursive(candidates, target);
        
        // convert set to list.
        for(List<Integer> list : retSet) {
            ret.add(list);
        }
        
        return ret;
    }
}
