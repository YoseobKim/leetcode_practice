class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set checked = new HashSet();
        Set repeated = new HashSet();

        if(s.length() <= 10) return new ArrayList<>();
        
        for(int i = 0; i < s.length() - 9; i++) {
            String substr = s.substring(i, i + 10);
            
            if(checked.contains(substr)) {
                repeated.add(substr);
            } else {
                checked.add(substr);
            }
        }
        
        return new ArrayList(repeated);
    }
}
