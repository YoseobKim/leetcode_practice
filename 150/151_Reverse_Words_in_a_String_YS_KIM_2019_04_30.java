class Solution {
    public String reverseWords(String s) {
        Map<Integer, String> wordMap = new HashMap<>();
        
        String[] splitted = s.split(" ");
        if(splitted == null || splitted.length <= 0) return s.trim();

        for(int i = 0; i < splitted.length; i++) {
            wordMap.put(i, splitted[i]);
        }
        
        String ret = "";
        for(int i = wordMap.size() - 1; i >= 0; i--) {
            String item = wordMap.get(i);
            if(item.equals("") || item.equals(" ")) continue;
            if(i == 0) ret += item.trim();
            else ret += item.trim() + " ";
        }
        
        return ret.trim();
    }
}
