class Solution {
    // Time limit exceeded
    private boolean contains(String s, char[] tArr) {
        // sort s
        char tempArray[] = s.toCharArray(); 
        Arrays.sort(tempArray);
        int sStart = 0;
        int matchCount = 0;
        for(int i = 0; i < tArr.length; i++) {
            char tChar = tArr[i];
            for(int j = sStart; j < tempArray.length; j++) {
                if(tChar == tempArray[j]) {
                    sStart = j + 1;
                    matchCount++;
                    break;
                }
            }
        }
        return matchCount == tArr.length;
    }
    
    public String minWindow(String s, String t) {
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);
        if(s.length() <= 0 || tArr.length <= 0) return "";
        if(tArr.length <= 1) {
            for(int i = 0; i < s.length(); i++) {
                if(tArr[0] == s.charAt(i)) {
                    return "" + tArr[0];
                }
            }
            return "";
        }
        
        if(s.equals(t)) return t;
        
        ArrayList<String> strList = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(j - i < t.length() - 1) continue;
                String substring = s.substring(i, j + 1);
                if(contains(substring, tArr)) {
                    strList.add(substring);
                }
            }
        }
        
        int minIndex = -1;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < strList.size(); i++) {
            String str = strList.get(i);
            if(str.length() < minLen) {
                minIndex = i;
                minLen = str.length();
            }
        }
        
        return minIndex < 0 ? "" : strList.get(minIndex);
    }
}
