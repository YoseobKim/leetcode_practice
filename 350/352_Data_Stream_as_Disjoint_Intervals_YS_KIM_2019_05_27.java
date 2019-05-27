class SummaryRanges {
    private SortedSet<Integer> set = new TreeSet<>();    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    
    public void addNum(int val) {
        set.add(val);
    }
    
    public int[][] getIntervals() {
        List<List<Integer>> retHelper = new ArrayList<>();
        if(set.size() == 0) return new int[0][0];
        
        Iterator<Integer> setIter = set.iterator();
        int prev = setIter.next();
        List<Integer> listItem = new ArrayList<>();
        listItem.add(prev);
        listItem.add(prev);
        retHelper.add(listItem);
        
        while(setIter.hasNext()) {
            int cur = setIter.next();
            if(cur - prev == 1) {
                List<Integer> listItemToUpdate = retHelper.get(retHelper.size() - 1);
                listItemToUpdate.set(1, cur);
                retHelper.set(retHelper.size() - 1, listItemToUpdate);                
            } else {
                // when jump occured
                // need to wrap up
                listItem = new ArrayList<>();
                listItem.add(cur);
                listItem.add(cur);
                retHelper.add(listItem);
            }
            prev = cur;
        }
        
        int[][] ret = new int[retHelper.size()][2];
        for(int i = 0; i < retHelper.size(); i++) {
            ret[i][0] = retHelper.get(i).get(0);
            ret[i][1] = retHelper.get(i).get(1);
        }
        
        return ret;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
