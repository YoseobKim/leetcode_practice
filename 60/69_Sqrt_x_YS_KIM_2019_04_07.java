class Solution {
    public int mySqrt(int x) {
        long sqrt = x;
        while (sqrt * sqrt > x)
            sqrt = (sqrt + x / sqrt) / 2;
        return (int) sqrt;
    }
}
