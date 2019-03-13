// Basic idea is same with 39.
// as the question only accepts unique combinations,
// only added logic is remove specific element in the array
// and do same thing with 39.
class Solution {
    private int[] removeElement(int[] arr, int index) {
        int[] ret = new int[arr.length - 1];
        
        int indexForRet = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i == index) continue;
            ret[indexForRet++] = arr[i];
        }
        return ret;
    }
    
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
                int[] candidatesRemoveItem = removeElement(candidates, i);
                Set<List<Integer>> prev = combinationSumRecursive(candidatesRemoveItem, diff);
            
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
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
