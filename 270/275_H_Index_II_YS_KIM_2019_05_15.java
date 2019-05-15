class Solution {
    public int hIndex(int[] citations) {
        int ret = 0;
        if(citations.length <= 0) return 0;
        
        int min = citations[0];
        ret = min; // initially it should be min
        
        if(citations.length <= 1) return Math.min(1, ret);
        
        int left = 0;
        int right = citations.length - 1;
       
        while(left <= right && right < citations.length && left >= 0) {
            int mid = (left + right) / 2;
//            System.out.println(left + " : " + right + " = " + mid);
            int item = citations[mid];
            int rightLen = citations.length - mid;
/*            
            if(item == citations[mid - 1]) {
                // left side have duplication.
                // right should be extended.
                int index = mid - 1;
                while(item == citations[index--]) {
                    rightLen++;
                }
            }
*/            
            if(rightLen >= item) {
                ret = Math.max(ret, item);
                left = mid + 1;
            } else {
                item = rightLen;
                ret = Math.max(ret, item);
                right = mid - 1;
            }
        }
        
        return Math.min(ret, citations.length);
    }
}
