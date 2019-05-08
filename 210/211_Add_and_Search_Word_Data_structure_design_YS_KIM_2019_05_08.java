class WordDictionary {
    private Map<Integer, Set<String>> memo = new HashMap<>();
    
    // Initialize your data structure here.
    public WordDictionary() {
        
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        int key = word.length();
        Set<String> value = memo.getOrDefault(key, new HashSet<>());
        value.add(word);
        memo.put(key, value);
    }
    
    // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int key = word.length();
        
        if(!memo.containsKey(key)){
            return false;
        }
        
        Set<String> value = memo.get(key);
        if(isWord(word)){
            return value.contains(word);
        }
        
        for(String s : value){
            if(isSame(s, word)){
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isWord(String word) {
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') return false;
        }
        return true;
    }
    
    private boolean isSame(String comp, String search) {
        if(comp.length() != search.length()) return false;
        
        for(int i = 0; i < comp.length(); i++) {
            char compChar = comp.charAt(i);
            char searchChar = search.charAt(i);
            if(searchChar == '.') continue;
            if(compChar != searchChar) return false;
        }
        
        return true;
    }
}
/* 
// This implementation results time limit exceeded as it is O(2^len)
class WordDictionary {
    private Set<String> searchSet = new HashSet<>();
    private Map<String, Set<String>> memo = new HashMap<>();
    
    // Initialize your data structure here.
    public WordDictionary() {
        
    }
    
    private Set<String> placeDots(String input) {
        Set<String> ret = new HashSet<>();
        if(memo.containsKey(input)) return memo.get(input);
        if(input.length() <= 0) return ret;
        if(input.length() <= 1) {
            ret.add(".");
            ret.add("" + input.charAt(0));
            memo.put(input, ret);
            return ret;
        }
        Set<String> substrDots = placeDots(input.substring(0, input.length() - 1));
        for(String s : substrDots) {
            ret.add(s + ".");
            ret.add(s + input.charAt(input.length() - 1));
        }
        memo.put(input, ret);
        return ret;
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        Set<String> dots = placeDots(word);
        searchSet.addAll(dots);
    }
    
    // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchSet.contains(word);
    }
}
*/
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
