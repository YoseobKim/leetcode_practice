class Solution {
    private List<List<Integer>> makeOpenParenthesisList(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n <= 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            ret.add(list);
            return ret;
        }
        int maxArrNum = n * 2;
        int maxOpenParenthesisIdx = maxArrNum - 1; // the last index should be a closing parenthesis.
        List<List<Integer>> prev = makeOpenParenthesisList(n - 1);
        for(List<Integer> list : prev) {
            for(int i = list.get(list.size() - 1) + 1; i < maxOpenParenthesisIdx; i++) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(i);
                ret.add(newList);
            }
        }
        return ret;
    }
    
    private char[] initializeWithClosings(int n) {
        char[] sArr = new char[n * 2];
        for(int i = 0; i < sArr.length; i++) {
            sArr[i] = ')';
        }
        return sArr;
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        List<List<Integer>> openIndexList = makeOpenParenthesisList(n);
        for(List<Integer> openIndexes : openIndexList) {
            char[] sArr = initializeWithClosings(n);
            for(Integer i : openIndexes) {
                sArr[i] = '(';
            }
            String str = new String(sArr);
            ret.add(str);
        }
        return ret;
    }
}
