class Solution {
    private boolean isPalindrome(String word1, String word2) {
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        if(word1.equals(sb2.reverse().toString())) return true;
        String word = sb1.append(word2).toString();
        return word.equals(new StringBuilder(word).reverse().toString());
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i == j) continue;
                String word1 = words[i];
                String word2 = words[j];
                if(isPalindrome(word1, word2)) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    ret.add(arr);
                }
            }
        }
        return ret;
    }
}
