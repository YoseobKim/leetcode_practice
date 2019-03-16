class Solution {
    private Map<String, List<String>> strListMap = new HashMap<>();
    
    // Method to sort a string alphabetically 
    private String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 
    
    public List<List<String>> groupAnagrams(String[] strs) {        
        for(String s : strs) {
            String sKey = sortString(s); // sort it first to determine whether the string s is a anagram or not.
            List<String> strList = strListMap.get(sKey);

            if(strList != null) {
                // have string. which means target string s is anagram.
                // 1. insert into the list.
                strList.add(s);
            } else {
                // not stored in a map.
                // 1. need to create a list and store it into the map.
                strList = new ArrayList<>();
                strList.add(s);
            }
            strListMap.put(sKey, strList);

        }

        return new ArrayList<List<String>>(strListMap.values());
    }
}
