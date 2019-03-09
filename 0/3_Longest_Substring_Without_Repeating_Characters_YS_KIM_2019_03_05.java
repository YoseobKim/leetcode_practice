class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> alphaMap = new HashSet<>();
        int maxlen = 0;
        int res = 0;
        
        for(int i = 0; i < s.length(); i++) {
            Character item = s.charAt(i);
            if(!alphaMap.contains(item)) {
                alphaMap.add(item);
                maxlen = maxlen > alphaMap.size() ? maxlen : alphaMap.size();
            }
            else {
                Set<Character> alphaMapNew = new HashSet<>();
                // reverse search on string that starts from index - 1 
                // to find the longest substr that does not meet same alphabet with index.
                // This theory is based on the hypothesis that before we found the repeatation on the str
                // current result can be potentially the longest substr
                for(int reverse = i - 1; reverse > 0; reverse--) {
                    Character reverseItem = s.charAt(reverse);
                    if(reverseItem != item) {
                        alphaMapNew.add(reverseItem);
                    } else break;
                }
                alphaMapNew.add(item);
                alphaMap.clear();
                alphaMap.addAll(alphaMapNew);
            }

        }
        return maxlen;
    }
}
