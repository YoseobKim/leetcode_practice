class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ret = new ArrayList<>();
        
        if(rowIndex <= 0) {
            List<Integer> retList =  new ArrayList<>();
            retList.add(1);
            return retList;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ret.add(first); // initialize with first
        
        for(int i = 1; i < rowIndex + 1; i++) {
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
        
        return ret.get(rowIndex);        
    }
}
