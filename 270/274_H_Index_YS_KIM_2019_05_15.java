class Solution {
    public int hIndex(int[] citations) {
        int ret = 0;
        if(citations.length <= 0) return 0;
        
        int min = Integer.MAX_VALUE;
        for(int i : citations) min = Math.min(min, i);
        min = Math.min(min, citations.length);
        ret = min; // initially it should be min
        
        if(citations.length <= 1) return Math.min(1, ret);
        
        for(int h = 0; h <= citations.length; h++) {
            List<Integer> moreOrEqualThanH = new ArrayList<>();
            List<Integer> lessThanH = new ArrayList<>();
            for(int j = 0; j < citations.length; j++) {
                int item = citations[j];
                if(item >= h) moreOrEqualThanH.add(item);
                else lessThanH.add(item);
            }
            // N papers have at least h citations each, and the other N − h papers have no more than h citations each.
            if(moreOrEqualThanH.size() >= h) ret = Math.max(h, ret);
        }
        
        return ret;
    }
}
