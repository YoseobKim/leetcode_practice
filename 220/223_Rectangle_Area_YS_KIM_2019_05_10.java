class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int coveredX1 = Math.max(A, E);
        int coveredY1 = Math.max(B, F);
        // Since coveredX2, coveredY2 mean right most point of covered rect, 
        // even I compare with coveredX1, coveredY1, it should be same if it is normal.
        // But if it is not normal, such as not covering each other,
        // coveredX2 == coveredX1 || coveredY2 == coveredY1.
        int coveredX2 = Math.max(Math.min(C, G), coveredX1);
        int coveredY2 = Math.max(Math.min(D, H), coveredY1);
        
        int rec1W = Math.abs(C - A);
        int rec1H = Math.abs(D - B);
        int rec2W = Math.abs(G - E);
        int rec2H = Math.abs(H - F);
        int coveredW = Math.abs(coveredX2 - coveredX1);
        int coveredH = Math.abs(coveredY2 - coveredY1);
        
        return (rec1W * rec1H) + (rec2W * rec2H) - (coveredW * coveredH);
    }
}
