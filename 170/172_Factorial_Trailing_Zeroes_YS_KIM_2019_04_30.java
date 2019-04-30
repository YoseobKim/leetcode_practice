class Solution {
    public int trailingZeroes(int n) {
        // Trailing Zeroes must come if the number can be divided by 5.
        // 4(0), 5(1), 8(1), 9(1), 10((2) 2 + (0)), 20((4) 4 + (0)), 25((6) 4 + (5)), 31((7) 6 + (6))
        return n < 5 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
