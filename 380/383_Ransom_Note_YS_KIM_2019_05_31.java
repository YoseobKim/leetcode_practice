class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> frequentMap = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int freq = frequentMap.getOrDefault(c, 0);
            freq++;
            frequentMap.put(c, freq);
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int freq = frequentMap.getOrDefault(c, 0);
            if(freq == 0) return false;
            freq--;
            frequentMap.put(c, freq);
        }
        
        return true;
    }
}
