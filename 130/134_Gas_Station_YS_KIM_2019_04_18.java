class Solution {
    private boolean canCompleteCircuitHelper(int[] gas, int[] cost, int start) {
        int index = start;
        int[] gas2 = new int[gas.length];
        System.arraycopy(gas, 0, gas2, 0, gas.length);

        for(int i = 0; i < gas.length; i++) {
            index = (start + i) % gas.length;
            int curGas = gas2[index];
            int curCost = cost[index];
            if(curGas - curCost < 0) return false;
            int nextIndex = (index + 1) % gas.length;
            gas2[nextIndex] = curGas - curCost + gas2[nextIndex];
        }
        return true;
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++) {
            if(canCompleteCircuitHelper(gas, cost, i)) return i;
        }
        return -1;
    }
}
