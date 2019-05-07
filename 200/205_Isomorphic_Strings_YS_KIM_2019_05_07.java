class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        Map<Character, Character> charChangeMap = new HashMap<>();
        Map<Character, Character> charChangeReverseMap = new HashMap<>();
        
        for(int i = 0; i < sCharArr.length; i++) {
            char sChar = sCharArr[i];
            char tChar = tCharArr[i];

            if(charChangeMap.containsKey(sChar)) {
                char tCharConvert = charChangeMap.get(sChar);
                if(tCharConvert != tChar) return false;
            } else if(charChangeReverseMap.containsKey(tChar)) {
                char sCharConvert = charChangeReverseMap.get(tChar);
                if(sCharConvert != sChar) return false;
            }else {
                charChangeMap.put(sChar, tChar);
                charChangeReverseMap.put(tChar, sChar);
            }
        }
        return true;
    }
}
