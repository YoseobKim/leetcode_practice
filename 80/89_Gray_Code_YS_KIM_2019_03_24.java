class Solution {
    // n = 1 0, 1
    // n = 2 (based on 1) | 1 << 1 (00, 01, 11, 10)
    //                                      -> from here new starts.
    //                                      -> reverse from prev.
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        if(n <= 0) {
            ret.add(0);
            return ret;
        }
        if(n <= 1) {
            ret.add(0);
            ret.add(1);
            return ret;
        }
        
        List<Integer> prev = grayCode(n - 1);
        ret.addAll(prev);
        
        for(int i = prev.size() - 1; i >= 0; i--) {
            int num = prev.get(i) | 1 << n - 1;
            ret.add(num);
        }
        
        return ret;    
    }
}
