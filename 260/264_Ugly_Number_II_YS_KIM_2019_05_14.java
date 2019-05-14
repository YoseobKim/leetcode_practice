class Solution {
    private List<Long> mergeLists(List<Long> l1, List<Long> l2) {
        List<Long> ret = new ArrayList<>();
        
        int left = 0;
        int right = 0;
        while(left < l1.size() && right < l2.size()) {
            long item1 = l1.get(left);
            long item2 = l2.get(right);
            if(item2 < item1) {
                right++;
                ret.add(item2);
            } else if(item2 == item1) {
                ret.add(item1);
                left++;
                right++;
            } else {
                left++;
                ret.add(item1);
            }
        }
                
        for(int i = left; i < l1.size(); i++) {
            ret.add(l1.get(i));
        }
        
        for(int i = right; i < l2.size(); i++) {
            ret.add(l2.get(i));
        }
        
        return ret;
    }
    
    public int nthUglyNumber(int n) {
        if(n > 1) {
            List<Long> uglyList1 = new ArrayList<>();
            uglyList1.add((long)1);
            uglyList1.add((long)2);
            uglyList1.add((long)3);
            uglyList1.add((long)4);
            uglyList1.add((long)5);
            if(n <= 5) return uglyList1.get(n - 1).intValue();
            
            for(int i = 0; i <= n; i++) {
                long targetNum = uglyList1.get(i);
                long ugly1 = targetNum * 2;
                long ugly2 = targetNum * 3;
                long ugly3 = targetNum * 5;
                List<Long> uglyList2 = new ArrayList<>();
                uglyList2.add(ugly1);
                uglyList2.add(ugly2);
                uglyList2.add(ugly3);
                uglyList1 = mergeLists(uglyList1, uglyList2);
            }
            if(uglyList1.size() >= n) {
                /*
                for(int item : uglyList1) {
                    System.out.print(item + ",");
                }
                
                System.out.println("");
                */    
                return uglyList1.get(n - 1).intValue();
            }
        }
        
        return 1;
    }
}
