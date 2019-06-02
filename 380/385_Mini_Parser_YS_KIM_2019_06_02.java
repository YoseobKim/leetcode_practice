/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger ret = new NestedInteger();
        if (s == null || s.length() == 0) return ret;
        if (s.charAt(0) != '[') {
            // normal number case
            ret.setInteger(Integer.parseInt(s));
            return ret;
        }
        else if (s.length() > 2) {
            int start = 1, count = 0;
            // it starts with [ so start from 1
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                // process entire [] block
                // ex) "[123,[456,[789]]]"
                // if c == ',' && count == 0 means, non [] block ends. (123)
                // if i == s.length() - 1 && count == 0 means, need to process entire left string not being processed with [] block ([456, [789]])
                if (count == 0 && (c == ',' || i == s.length() - 1)) {
                    String substring = s.substring(start, i);
                    ret.add(deserialize(substring));
                    // start from next
                    start = i + 1;
                }
                else if (c == '[') count++;
                else if (c == ']') count--;
            }
        }
        return ret;
    }
}
