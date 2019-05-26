class Solution {
    public String reverseVowels(String s) {
        if(s.length() <= 0) return "";
        if(s.length() <= 1) return s;
        List<Character> vowels = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if(t == 'a' || t == 'A' || t == 'e' || t == 'E' 
               || t == 'i' || t == 'I' || t == 'o' || t == 'O'
               || t == 'u' || t == 'U') {
                vowels.add(t);
            }
        }
        int vowelsEnd = vowels.size() - 1;
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if(t == 'a' || t == 'A' || t == 'e' || t == 'E' 
               || t == 'i' || t == 'I' || t == 'o' || t == 'O'
               || t == 'u' || t == 'U')  {
                ret.append(vowels.get(vowelsEnd--));
            }
            else {
                ret.append(t);
            }
        }
        
        return ret.toString();
    }
}
