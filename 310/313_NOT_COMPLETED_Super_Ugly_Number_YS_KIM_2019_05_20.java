class Solution {
    private List<Long> mergeLists(List<Long> l1, List<Long> l2) {
        List<Long> merged = new ArrayList<>();
        int left = 0;
        int right = 0;
        while(left < l1.size() && right < l2.size()) {
            long leftItem = l1.get(left);
            long rightItem = l2.get(right);
            if(leftItem < rightItem) {
                merged.add(leftItem);
                left++;
            } else if(leftItem == rightItem) {
                left++;
                right++;
                merged.add(leftItem);
            } else {
                merged.add(rightItem);
                right++;
            }
        }
        
        for(int i = left; i < l1.size(); i++) {
            merged.add(l1.get(i));
        }
        
        for(int i = right; i < l2.size(); i++) {
            merged.add(l2.get(i));
        }
        
        return merged;
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1) return 1;
        List<Long> uglyNums = new ArrayList<>();
        uglyNums.add(new Long(1));

        for(int prime : primes) {
            uglyNums.add(new Long(prime));
        }
                        
        int enough = n / primes.length;
        for(int index = 0; index < n; index++) {
            long targetNum = uglyNums.get(index);
            boolean breakMe = false;
            List<Long> newUglyNums = new ArrayList<>();
            for(int prime : primes) {
                long uglyNum = prime * targetNum;
                if(uglyNum > Integer.MAX_VALUE) {
                    breakMe = true;
                    break;
                }
                newUglyNums.add(uglyNum);
            }
            
            uglyNums = mergeLists(uglyNums, newUglyNums);
            if(breakMe) break;
        }
                
        return uglyNums.get(n - 1).intValue();
    }
}
