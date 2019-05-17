class MedianFinder {
    private List<Integer> list = new ArrayList<>();
    
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
        int len = list.size();
        if(len == 0) return 0.0;
        if(len <= 1) return list.get(0);
        if(len % 2 == 0) {
            int mid = len / 2;
            int item1 = list.get(mid - 1);
            int item2 = list.get(mid);
            return (item1 + item2) / 2.0;
        } else {
            int mid = len / 2;
            return list.get(mid);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
