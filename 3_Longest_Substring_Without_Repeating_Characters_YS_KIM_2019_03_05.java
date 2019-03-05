class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> alphaMap = new HashMap<>();
        int maxlen = 0;
        int res = 0;
        
        for(int i = 0; i < s.length(); i++) {
            Character item = s.charAt(i);
            if(!alphaMap.containsKey(item)) {
                alphaMap.put(item, true);
                maxlen = maxlen > alphaMap.keySet().size() ? maxlen : alphaMap.keySet().size();
            }
            else {
                Map<Character, Boolean> alphaMapNew = new HashMap<>();
                // reverse search on string that starts from index - 1 
                // to find the longest substr that does not meet same alphabet with index.
                // This theory is based on the hypothesis that before we found the repeatation on the str
                // current result can be potentially the longest substr
                for(int reverse = i - 1; reverse > 0; reverse--) {
                    Character reverseItem = s.charAt(reverse);
                    if(reverseItem != item) {
                        alphaMapNew.put(reverseItem, true);
                    } else break;
                }
                alphaMapNew.put(item, true);
                alphaMap.clear();
                alphaMap.putAll(alphaMapNew);
            }

        }
        return maxlen;
    }
}
