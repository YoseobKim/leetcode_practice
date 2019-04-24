public class HelloWorld{
    private static boolean canBeSubSequence(String S, String W) {
        boolean ret = false;
        if(S.length() < W.length()) return ret;
        int wIdx = 0;
        
        for(int i = 0; i < S.length(); i++) {
            if(wIdx >= W.length()) {
                ret = true;
                break;
            }
            char sChar = S.charAt(i);
            char wChar = W.charAt(wIdx);
            if(sChar == wChar) wIdx++;
        }
        
        return ret;
    }

    private static String longestSubSequence(String S, String[] D) {
        String longest = "";
        for(String trgt : D) {
            if(canBeSubSequence(S, trgt) && trgt.length() > longest.length()) {
                longest = trgt;
            }
        }
        return longest;
    }
    
    public static void main(String []args){
        String S = "abppplee";
        String[] D =  {"able", "ale", "apple", "bale", "kangaroo"};
        
        System.out.println(longestSubSequence(S, D));
    }
}
