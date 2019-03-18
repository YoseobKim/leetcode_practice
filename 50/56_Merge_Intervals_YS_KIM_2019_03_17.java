/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    private void print(List<Interval> intervals) {
        for(int i = 0; i < intervals.size(); i++) {
            System.out.print("[" + intervals.get(i).start + ", " + intervals.get(i).end + "]");
        }
        System.out.println("");
    }
    
    private boolean check(Interval one, Interval two) {
        for(int i = one.start; i <= one.end; i++) {
            for(int j = two.start; j <= two.end; j++) {
                // any of range of two lays under range of one,
                if(i == j) return true;
            }
        }
        return false;
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        // for better removing and adding, use LinkedList.
        List<Interval> ret = new LinkedList<>(intervals);
        // for better treatment, sort.
        Collections.sort(ret, new Comparator<Interval>() {
	        public int compare(Interval s1, Interval s2) {
	            int start1 = s1.start;
	            int start2 = s2.start;

	            /*For ascending order*/
	            return start1 - start2;
        }});

        // check indexes [0,1], [1,2], [2,3], [3,4]...
        for(int i = 0, j = 1; j < ret.size(); i++, j++) {
            Interval one = ret.get(i);
            Interval two = ret.get(j);
            
            if(check(one, two)) {
                int smallest = one.start >= two.start ? two.start : one.start;
                int largest = one.end >= two.end ? one.end : two.end;
                // make widest range of interval using one and two.
                Interval merged = new Interval(smallest, largest);
                ret.set(i, merged);
                ret.remove(j); // remove j as it is merged with i.
                // index should be decreased by one as the item is merged.
                i--;
                j--;
            }
        }
        
        return ret;
    }
}
