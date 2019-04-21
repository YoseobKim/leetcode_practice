class Solution {
    Map<String, List<String>> memo = new HashMap<>();
    
    private List<String> wordBreakHelper(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<>();
        if(s.isEmpty() || s.trim().length() <= 0) {
            ret.add("");
        }
        
        s = s.trim();
        if(memo.containsKey(s)) return memo.get(s);

        
        for(int i = 0; i < wordDict.size(); i++) {
            String wordInDict = wordDict.get(i);
            int index = s.indexOf(wordInDict);
            if(index == 0) {
                String substring = "";
                
                String front = s.substring(0, index);
                String end = s.substring(index + wordInDict.length(), s.length());
                substring = front + " " + end;
                
                List<String> nextRet = wordBreakHelper(substring, wordDict);
                
                for(String nextStr : nextRet) {
                    if(nextStr.length() <= 0) ret.add(wordInDict);
                    else {
                        ret.add(wordInDict + " " + nextStr);
                    }
                }
            }
        }
        
        memo.put(s, ret);
        return ret;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = wordBreakHelper(s, wordDict);
        return ret;
    }
}
