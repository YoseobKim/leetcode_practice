class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, Integer> sFreqMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            int freq = sFreqMap.getOrDefault(item, 0);
            freq++;
            sFreqMap.put(item, freq);
        }
        
        StringBuilder extracted = new StringBuilder();
        
        int sIdx = 0;
        
        for(int i = 0; i < t.length(); i++) {
            char item = t.charAt(i);
            if(sFreqMap.containsKey(item)) {
                int freq = sFreqMap.get(item);
                if(freq > 0 && s.charAt(sIdx) == item) {
                    freq--;
                    extracted.append(item);
                    sIdx++;
                }
                sFreqMap.put(item, freq);
            }
        }
                
        return s.equals(extracted.toString());
    }
}
