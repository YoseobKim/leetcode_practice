import java.util.*;

public class HelloWorld{
    private static Set<Character> sCharMap = new HashSet<>();
    
    private static boolean canBeSubSequence(String S, String W) {
        boolean ret = false;
        if(S.length() < W.length()) return ret;
        if(S.length() == W.length() && S.equals(W)) return true;
        int wIdx = 0;
        
        for(int i = 0; i < S.length(); i++) {
            if(wIdx >= W.length()) {
                ret = true;
                break;
            }
            char sChar = S.charAt(i);
            char wChar = W.charAt(wIdx);
            if(!sCharMap.contains(wChar)) break;
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
        
        for(int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            sCharMap.add(c);
        }
        
        System.out.println(longestSubSequence(S, D));
    }
}
