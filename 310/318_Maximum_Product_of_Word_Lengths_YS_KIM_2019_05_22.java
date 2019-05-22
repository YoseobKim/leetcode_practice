class Solution {
    public int maxProduct(String[] words) {
        if(words.length <= 0) return 0;
        List<Set<Character>> charSetList = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++) {
            String str = words[i];
            Set<Character> alphaSet = new HashSet<>();
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                alphaSet.add(c);
            }
            charSetList.add(alphaSet);
        }
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            String item1 = words[i];
            for(int j = i + 1; j < words.length; j++) {
                String item2 = words[j];
                Set<Character> item1Set = new HashSet<>(charSetList.get(i));
                Set<Character> item2Set = new HashSet<>(charSetList.get(j));
                int origSize = item1Set.size();
                item1Set.removeAll(item2Set);
                if(item1Set.size() == origSize) {
                    // no duplicate
                    int dup = item2.length() * item1.length();
                    max = Math.max(max, dup);
                }
            }
        }
        
        return max;
    }
}
