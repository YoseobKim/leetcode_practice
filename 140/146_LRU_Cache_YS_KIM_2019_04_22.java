class LRUCache {
    private Map<Integer, Integer> cache = new HashMap<>();
    private List<Integer> rnuList = new ArrayList<>();
    private int capacity = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            rnuList.remove(new Integer(key));
            rnuList.add(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            // just update
            cache.put(key, value);
            rnuList.remove(new Integer(key));
            rnuList.add(key);
            return;
        }
        int size = cache.size();
        if(size < capacity) {
            rnuList.add(key);
            cache.put(key, value);
        } else {
            int removeKey = rnuList.get(0);
            rnuList.remove(0);
            cache.remove(removeKey);
            cache.put(key, value);
            rnuList.add(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
