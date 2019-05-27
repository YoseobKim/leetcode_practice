class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            num1Set.add(nums1[i]);
        }
        Set<Integer> num2Intersect = new HashSet<>();
        for(int i = 0; i < nums2.length; i++) {
            if(num1Set.contains(nums2[i])) num2Intersect.add(nums2[i]);
        }
        
        List<Integer> retHelper = new ArrayList<>(num2Intersect);
        int[] ret = new int[retHelper.size()];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = retHelper.get(i);
        }
        
        return ret;
    }
}
