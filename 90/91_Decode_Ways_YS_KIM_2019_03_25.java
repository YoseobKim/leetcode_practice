class Solution {
    private boolean isDecodeable(String s) {
        if(s.charAt(0) == '0') return false; // edge case
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 26;
    }
    
    public int numDecodings(String s) {
        if(s.length() <= 0) return 0;
        if(s.charAt(0) == '0') return 0;
        int[] waysToDecode = new int[s.length() + 1];
        
        // initial state
        waysToDecode[0] = 1;
        waysToDecode[1] = 1;
        
        for(int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            char prev = s.charAt(i - 1);
            if(!isDecodeable("" + current) && !isDecodeable("" + prev + current)) return 0;
            if(isDecodeable("" + current) && isDecodeable("" + prev + current)) {
                waysToDecode[i + 1] = waysToDecode[i] + waysToDecode[i - 1];
            }
            else if(isDecodeable("" + current)) {
                // only current character is valid
                waysToDecode[i + 1] = waysToDecode[i];
            } else {
                // only prev character is valid
                waysToDecode[i + 1] = waysToDecode[i - 1];
            }
        }
        
        return waysToDecode[s.length()];
    }
}
