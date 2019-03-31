class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    public int numDistinct(String s, String t) {
        if(t.length() <= 0) return 0;
        if(s.equals(t)) return 1;
        if(memo.get(s + ":" + t) != null) return memo.get(s + ":" +  t);
        char target = t.charAt(0);
        if(t.length() <= 1) {
            int ret = 0;
            for(int i = 0; i < s.length(); i++) {
                char sTarget = s.charAt(i);
                if(sTarget == target) ret++;
            }
            memo.put(s + ":" +  t, ret);
            return ret;
        }
        String newT = t.substring(1);
        int ret = 0;
        for(int i = 0; i < s.length(); i++) {
            char sTarget = s.charAt(i);
            if(target == sTarget) {
                ret++;
                String newS = s.substring(i + 1);
                int newRet = numDistinct(newS, newT);
//                System.out.println(s + " : " + t + " : " + newRet);
                if(newRet <= 0) ret--;
                else ret += newRet - 1;
            }
        }
        memo.put(s + ":" +  t, ret);
        return ret;
    }
}
