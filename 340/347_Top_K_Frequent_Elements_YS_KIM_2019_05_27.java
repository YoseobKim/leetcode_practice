class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // key : num, value : frequency
        Map<Integer, Integer> frequentMap = new HashMap<>();
        if(nums.length <= 0) return null;
        
        for(int i = 0; i < nums.length; i++) {
            int item = nums[i];
            int frequency = frequentMap.getOrDefault(item, 0);
            frequency++;
            frequentMap.put(item, frequency);
        }
        
        // key : frequency, value : item
        Map<Integer, Set<Integer>> frequentMapReverse = new HashMap<>();
        for(int item : frequentMap.keySet()) {
            int freq = frequentMap.get(item);
            Set<Integer> itemSet = frequentMapReverse.getOrDefault(freq, new HashSet<>());
            itemSet.add(item);
            frequentMapReverse.put(freq, itemSet);
        }
        
        List<Integer> retHelper = new ArrayList<>(frequentMapReverse.keySet());
        Collections.sort(retHelper);
        List<Integer> ret = new ArrayList<>();
        
        for(int i = retHelper.size() - 1; i >= 0; i--) {
            int freq = retHelper.get(i);
            ret.addAll(frequentMapReverse.get(freq));
            if(ret.size() >= k) break;
        }
        return ret;
    }
}
