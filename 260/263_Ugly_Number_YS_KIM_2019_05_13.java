class Solution {
    private Map<Integer, Boolean> memo = new HashMap<>();
    
    private boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        // negative numbers are not able to be ugly number since it must have minus number to be multiplied.
        if(num == 1 || num == 2 || num == 3 || num == 5) return true;
        if(memo.containsKey(num)) return memo.get(num);
        if(isPrime(num)) {
            memo.put(num, false);
            return false;
        }
        
        boolean ret = false;
        if(num % 2 == 0) {
            int dividedBy2 = num / 2;
            ret |= isUgly(dividedBy2);
        } else if(num % 3 == 0) {
            int dividedBy3 = num / 3;
            ret |= isUgly(dividedBy3);
        } else if(num % 5 == 0) {
            int dividedBy5 = num / 5;
            ret |= isUgly(dividedBy5);
        }
        
        memo.put(num, ret);
        return ret;
    }
}
