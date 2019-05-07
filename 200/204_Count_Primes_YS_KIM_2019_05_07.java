class Solution {
    /*
    // This algorithm is nlogn but it results time limit exceeded.
    // Need to be optimized little bit.
    private Map<Integer, Boolean> memo = new HashMap<>();
    
    private boolean isPrime(int n) {
        if(memo.containsKey(n)) return memo.get(n);
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                memo.put(n, false);
                return false;
            }
        }
        memo.put(n, true);
        return true;
    }
    */

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
