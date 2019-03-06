class Solution {
    private final String[][] DIGITS_LETERS_MAP = {
        {""},
        {""},
        {"a", "b", "c"},
        {"d", "e", "f"},
        {"g", "h", "i"},
        {"j", "k", "l"},
        {"m", "n", "o"},
        {"p", "q", "r", "s"},
        {"t", "u", "v"},
        {"w", "x", "y", "z"}
        // according to my test result, *, # are not needed to be processed.
    };
    
    private boolean isNum(char c) {
        int asciiCode = (int) c;
        return (asciiCode >= 48 && asciiCode <= 57);
    }
    
    private List<String> recursiveSetMaker(List<List<String>> sets) {
        if(sets.size() < 1) return new ArrayList<String>();
        if(sets.size() == 1) return makeSetUsingStringSets(sets.get(0), new ArrayList<String>());
        if(sets.size() == 2) return makeSetUsingStringSets(sets.get(0), sets.get(1));
        int mid = sets.size() / 2;
        List<List<String>> head = sets.subList(0, mid);
        List<List<String>> tail = sets.subList(mid, sets.size());
        
        List<String> set1 = recursiveSetMaker(head);      
        List<String> set2 = recursiveSetMaker(tail);

        return makeSetUsingStringSets(set1, set2);
    }
    
    private List<String> makeSetUsingStringSets(List<String> set1, List<String> set2) {
        List<String> ret = new ArrayList<>();
        if(set1.size() < 1) {
            return set2;
        }
        if(set2.size() < 1) {
            return set1;
        }
        
        for(String s1 : set1) {
            for(String s2 : set2) {
                ret.add(s1 + s2);
            }
        }
        return ret;
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        char[] sArr = digits.toCharArray();
        
        List<List<String>> candidates = new ArrayList<>();
        for(int i = 0; i < sArr.length; i++) {
            char digit = sArr[i];
            if(isNum(digit)) {
                int num = ((int)digit - 48);
                candidates.add(Arrays.asList(DIGITS_LETERS_MAP[num]));
            }
        }
        
        return recursiveSetMaker(candidates);
    }
}
