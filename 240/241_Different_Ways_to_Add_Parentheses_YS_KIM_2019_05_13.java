class Solution {
    private Map<String, List<Integer>> memo = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        if(memo.containsKey(input)) return memo.get(input);
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                String prev = input.substring(0, i);
                String next = input.substring(i + 1, input.length());
                List<Integer> prevList = diffWaysToCompute(prev);
                List<Integer> nextList = diffWaysToCompute(next);
                
                for(int p : prevList) {
                    for(int n : nextList) {
                        if(c == '+') ret.add(p + n);
                        else if(c == '-') ret.add(p - n);
                        else ret.add(p * n);
                    }
                }
            }
            
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        
        memo.put(input, ret);
        return ret;
    }
}
