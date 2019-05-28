class Solution {
    private HashMap<Integer, Set<Integer>> memo = new HashMap<>();
    private boolean distinct(Set<Integer> items, int num) {
        for(int i : items) {
            if(i % num != 0 && num % i != 0) return false;
        }
        return true;
    }
    
    private boolean distinct(Set<Integer> items1, Set<Integer> items2) {
        for(int i : items1) {
            for(int j : items2) {
                if(i == j) continue;
                if(i % j != 0 && j % i != 0) return false;
            }
        }
        return true;
    }
    
    private Set<Integer> largestDivisibleSubsetHelper(int[] nums, int index) {
        if(nums.length > index) {
            if(memo.containsKey(index)) return memo.get(index);
            
            Set<Integer> ret = new HashSet<>();
            ret.add(nums[index]);
            Set<Integer> nextToAdd = new HashSet<>();
            for(int i = index + 1; i < nums.length; i++) {
                Set<Integer> next = largestDivisibleSubsetHelper(nums, i);
                if(distinct(next, nums[index])) {
                    if(nextToAdd.size() < next.size()) {
                        nextToAdd = next;
                    }
                }
            }
            
            ret.addAll(nextToAdd);
            memo.put(index, ret);
            return ret;
        }
        return new HashSet<>();
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Set<Integer> retHelper = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> cur = largestDivisibleSubsetHelper(nums, i);
            if(distinct(retHelper, cur)) retHelper.addAll(cur);
            if(retHelper.size() < cur.size()) retHelper = cur;
        }
        return new ArrayList<>(retHelper);
    }
}
