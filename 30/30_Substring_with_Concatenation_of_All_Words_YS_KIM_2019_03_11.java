class Solution {
    private List<List<Integer>> getAllCombination(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n < 1) { // 0
            List<Integer> one = new ArrayList<>();
            one.add(n);
            ret.add(one);
            return ret;
        }
        
        List<List<Integer>> prev = getAllCombination(n - 1);
        for(List<Integer> item : prev) {
            for(int i = 0; i <= n; i++) {
                List<Integer> newItem = new ArrayList<>(n);
                // insert new word into n-1 set.
                newItem.addAll(item);
                newItem.add(i, n);
                ret.add(newItem);
            }
        }
        
        return ret;
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Set<String> compSet = new HashSet<>();
        List<List<Integer>> combs = getAllCombination(words.length - 1);
        String substring = "";

        for(List<Integer> item : combs) {
            substring = "";
            for(Integer i : item) {
                String strItem = words[i];
                substring += strItem; //make all concatination
            }
            // if contains, do not proceed
            if(!compSet.contains(substring)) compSet.add(substring);
            else continue;

            int index = s.indexOf(substring); // and find substring
            while(index >= 0) { // for entire string
                ret.add(index);
                index = s.indexOf(substring, index + 1); // from next
            }
        }
        
        return ret;
    }
}
