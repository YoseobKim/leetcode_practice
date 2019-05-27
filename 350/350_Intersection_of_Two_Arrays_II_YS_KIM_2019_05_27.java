class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] longer = nums1.length >= nums2.length ? nums1 : nums2;
        int[] shorter = nums1.length >= nums2.length ? nums2 : nums1;
        Map<Integer, Integer> longerMap = new HashMap<>();
        for(int i = 0; i < longer.length; i++) {
            int freq = longerMap.getOrDefault(longer[i], 0);
            freq++;
            longerMap.put(longer[i], freq);
        }
        List<Integer> retHelper = new ArrayList<>();
        for(int i = 0; i < shorter.length; i++) {
            if(longerMap.containsKey(shorter[i])) {
                int freq = longerMap.get(shorter[i]);
                if(freq > 0) {
                    retHelper.add(shorter[i]);
                    freq--;
                    longerMap.put(shorter[i], freq);
                }
            }
        }
        
        int[] ret = new int[retHelper.size()];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = retHelper.get(i);
        }
        
        return ret;
    }
}
