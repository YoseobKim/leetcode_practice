class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) small = n;
            // this else if will be small < n <= secondSmall
            else if (n <= secondSmall) secondSmall = n;
            // this else will be small < secondSmall < n
            else return true;
        }
        return false;
    }
}
