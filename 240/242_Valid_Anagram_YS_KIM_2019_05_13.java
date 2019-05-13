class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sAppearanceMap = new HashMap<>();
        if(s.length() != t.length()) return false;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int appearance = sAppearanceMap.getOrDefault(c, 1);
            appearance++;
            sAppearanceMap.put(c, appearance);
        }
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(sAppearanceMap.containsKey(c)) {
                int appearance = sAppearanceMap.get(c);
                appearance--;
                if(appearance <= 0) return false;
                sAppearanceMap.put(c, appearance);
            } else {
                return false;
            }
        }
        
        return true;
    }
}
