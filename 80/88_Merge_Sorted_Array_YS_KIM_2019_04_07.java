class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> arr = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while(i1 < m && i2 < n) {
            int item1 = nums1[i1];
            int item2 = nums2[i2];
            if(item1 < item2) {
                arr.add(item1);
                i1++;
            } else {
                arr.add(item2);
                i2++;
            }
        }
        
        if(i1 < m) {
            for(int i = i1; i < m; i++) {
                arr.add(nums1[i]);
            }
        } else if(i2 < n) {
            for(int i = i2; i < n; i++) {
                arr.add(nums2[i]);
            }
        }
        
        for(int i = 0; i < arr.size(); i++) {
            nums1[i] = arr.get(i);
        }
        
        return;
    }
}
