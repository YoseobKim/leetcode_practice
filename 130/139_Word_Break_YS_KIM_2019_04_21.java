class Solution {
    Set<String> dictSet = new HashSet<>();
    
    private boolean wordBreakHelper(String s, List<String> wordDict, int start) {
        if(s.isEmpty() || s.trim().length() <= 0) return true;
        if(start >= wordDict.size()) return false;
        for(int i = start; i < wordDict.size(); i++) {
            String wordInDict = wordDict.get(i);
            if(s.contains(wordInDict)) {
                String[] splitted = s.split(wordInDict);
                // this will remove all wordInDict from the string and split s into array
                String substring = "";
                for(String sub : splitted) {
                    if(dictSet.contains(sub)) continue;
                    substring += sub + " ";
                }
                boolean ret = wordBreakHelper(substring, wordDict, i + 1);
                if(ret) return true;
            }
        }
        
        return false;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict) {
            dictSet.add(word);
        }
        
        return wordBreakHelper(s, wordDict, 0);
    }
}
