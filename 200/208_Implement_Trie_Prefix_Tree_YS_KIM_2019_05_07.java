class Trie {
    private Set<String> startsWithSet = new HashSet<>();
    private Set<String> searchSet = new HashSet<>();

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        for(int i = 0; i < word.length() + 1; i++) {
            String substr = word.substring(0, i);
            substr = substr + "*";
            startsWithSet.add(substr);
        }
        searchSet.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchSet.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWithSet.contains(prefix + "*");
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
