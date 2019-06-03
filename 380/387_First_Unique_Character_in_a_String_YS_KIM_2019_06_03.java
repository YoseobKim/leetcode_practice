class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            int frequency = freq.getOrDefault(item, 0);
            frequency++;
            freq.put(item, frequency);
        }
        
        for(int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if(freq.get(item) <= 1) return i;
        }
        
        return -1;
    }
}
