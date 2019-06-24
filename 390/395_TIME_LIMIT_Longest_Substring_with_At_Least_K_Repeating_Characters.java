class Solution {
    private boolean exceed(String sub, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < sub.length(); i++) {
            char item = sub.charAt(i);
            int freq = freqMap.getOrDefault(item, 0);
            freq++;
            freqMap.put(item, freq);
        }
        
        for(Character item : freqMap.keySet()) {
            int ret = freqMap.get(item);
            if(ret < k) return false;
        }
        
        return true;
    }
    
    public int longestSubstring(String s, int k) {
        int ret = 0;
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                //System.out.println(substring);
                if(exceed(substring, k)) ret = Math.max(substring.length(), ret);
            }
        }
        
        return ret;
    }
}
