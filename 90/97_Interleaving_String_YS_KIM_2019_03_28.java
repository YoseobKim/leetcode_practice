class Solution {
    private Map<String, Set<String>> memo = new HashMap<>();
    
    private Set<String> interleave(String s, String t) {
        Set<String> result = new HashSet<String>();
        String key = s + ":" + t;
        if(memo.get(key) != null) return memo.get(key);
        if (t.isEmpty()) {;
            result.add(s);
        } else if (s.isEmpty()) {
            result.add(t);
        } else {
            for (int i = 0; i <= s.length(); i++) {
                char c = t.charAt(0);
                String left = s.substring(0, i);
                String right = s.substring(i);
                for (String u : interleave(right, t.substring(1))) {
                    result.add(left + c + u);
                }
            }
        }
        memo.put(key, result);
        return result;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        Set<String> candidates = interleave(s1, s2);
        return candidates.contains(s3);
    }
}
