class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            int freq = sMap.getOrDefault(item, 0);
            freq++;
            sMap.put(item, freq);
        }
        
        for(int i = 0; i < t.length(); i++) {
            char item = t.charAt(i);
            int freq = tMap.getOrDefault(item, 0);
            freq++;
            tMap.put(item, freq);
        }
        
        for(char key : tMap.keySet()) {
            int sFreq = sMap.getOrDefault(key, 0);
            int tFreq = tMap.get(key);
            if(sFreq != tFreq) return key;
        }
        
        return '0';
    }
}
