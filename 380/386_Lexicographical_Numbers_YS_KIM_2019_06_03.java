class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> strs = new ArrayList<>();
        for(int i = 1; i <= n; i++) strs.add("" + i);
        Collections.sort(strs);
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < strs.size(); i++) ret.add(Integer.parseInt(strs.get(i)));
        return ret;
    }
}
