class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        
        if(numRows <= 0) return ret;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ret.add(first); // initialize with first
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            item.add(1);
            List<Integer> prev = ret.get(i - 1);
            
            for(int j = 1; j < i; j++) {
                int val = prev.get(j - 1) + prev.get(j);
                item.add(val);
            }
            
            item.add(1);
            ret.add(item);
        }
        
        return ret;
    }
}
