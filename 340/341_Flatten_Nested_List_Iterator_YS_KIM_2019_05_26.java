/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = null;
    private Iterator<Integer> listIterator = null;
    
    private List<Integer> extractAll(List<NestedInteger> nestedList) {
        List<Integer> ret = new ArrayList<>();
        for(NestedInteger item : nestedList) {
            if(item.isInteger()) {
                ret.add(item.getInteger());
            } else {
                ret.addAll(extractAll(item.getList()));
            }
        }
        return ret;
    }
    
    public NestedIterator(List<NestedInteger> nestedList) {
        list = extractAll(nestedList);
//        for(int i : list) {
//            System.out.print(i + ",");
//        }
//        System.out.println("");
        listIterator = list.iterator();
    }

    @Override
    public Integer next() {
        return listIterator.next();
    }

    @Override
    public boolean hasNext() {
        return listIterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
