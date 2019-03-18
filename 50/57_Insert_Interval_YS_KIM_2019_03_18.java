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
    private boolean check(Interval one, Interval two) {
        for(int i = one.start; i <= one.end; i++) {
            for(int j = two.start; j <= two.end; j++) {
                // any of range of two lays under range of one,
                if(i == j) return true;
            }
        }
        return false;
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // for better removing and adding, use LinkedList.
        List<Interval> ret = new LinkedList<>();
        if(intervals.size() <= 0) {
            ret.add(newInterval);
            return ret;
        }
        if(intervals.size() <= 1) {
            Interval item = intervals.get(0);
            if(check(item, newInterval)) {
                // [[1,5]]
                // [2,3]
                // In this case, the item and the newInterval should be merged.
                int smallerStart = item.start <= newInterval.start ? item.start : newInterval.start;
                int largerEnd = item.end >= newInterval.end ? item.end : newInterval.end;
                ret.add(new Interval(smallerStart, largerEnd));
                return ret;
            } else {
                // [[1,5]]
                // [6,8]
                // no need to be merged.
                ret.add(item);
                ret.add(newInterval);
                
                // In the description, there was nothing about sorting, but it seems like they are checking it...
                // [[1,5]]
                // [0,0]
                // OK ret : [[0,0],[1,5]]
                // NG ret : [[1,5],[0,0]]
                
                Collections.sort(ret, new Comparator<Interval>() {
	                public int compare(Interval s1, Interval s2) {
	                    int start1 = s1.start;
	                    int start2 = s2.start;

	                    /*For ascending order*/
	                    return start1 - start2;
                }});
                
                return ret;
            }
        }

        // for better treatment, sort.
        Collections.sort(intervals, new Comparator<Interval>() {
	        public int compare(Interval s1, Interval s2) {
	            int start1 = s1.start;
	            int start2 = s2.start;

	            /*For ascending order*/
	            return start1 - start2;
        }});
        
        int smallest = Integer.MAX_VALUE;
        int largest = 0;
        boolean mergeStart = false;
        boolean mergeEnd = false;
        for(int i = 0; i < intervals.size(); i++) {
            Interval item = intervals.get(i);
            if(check(item, newInterval)) {
                // From the the item is being able to be merged at the first time, 
                // the moment is the merge starting point. (As we sorted the lists)
                mergeStart = true;
                int smallerStart = item.start <= newInterval.start ? item.start : newInterval.start;
                smallest = smallerStart < smallest ? smallerStart : smallest;
                int largerEnd = item.end >= newInterval.end ? item.end : newInterval.end;
                largest = largest >= largerEnd ? largest : largerEnd;
            } else {
                if(!mergeStart) ret.add(item);
                else {
                    // merge end
                    Interval merged = new Interval(smallest, largest);
                    ret.add(merged);
                    for(int j = i; j < intervals.size(); j++) {
                        ret.add(intervals.get(j));
                    }
                    mergeEnd = true;
                    break;
                }
            }
        }
        
        if(mergeStart && mergeEnd) return ret; // normal case.
        
        if(mergeStart && !mergeEnd) {
            // abnormal case
            // [[1,5],[6,8]]
            // [5,6]
            // merging will be not finished in the loop.
            Interval merged = new Interval(smallest, largest);
            ret.add(merged);
        } else if(!mergeStart) {
            // even merge cannot be started.
            // just add newInterval into list and sort it.
            ret.add(newInterval);
            Collections.sort(ret, new Comparator<Interval>() {
	            public int compare(Interval s1, Interval s2) {
	                int start1 = s1.start;
	                int start2 = s2.start;

	                /*For ascending order*/
	                return start1 - start2;
            }});
        }
    
        return ret;
    }
}
