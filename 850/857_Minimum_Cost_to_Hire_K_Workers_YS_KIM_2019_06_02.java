class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        double ans = 1e9;

        for (int standard = 0; standard < N; ++standard) {
            // Must pay at least wage[standard] / quality[standard] per qual
            // Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
            double factor = (double) wage[standard] / quality[standard];
            double prices[] = new double[N];
            
            int index = 0;
            for (int worker = 0; worker < N; ++worker) {
                // proper wage for a worker
                double price = factor * quality[worker];
                if (price < wage[worker]) continue; // too high
                prices[index++] = price;
            }

            if (index < K) continue; // not enough workers
            
            Arrays.sort(prices, 0, index);
            double candidate = 0;
            for (int i = 0; i < K; i++)
                candidate += prices[i];
            ans = Math.min(ans, candidate);
        }

        return ans;
    }
}
