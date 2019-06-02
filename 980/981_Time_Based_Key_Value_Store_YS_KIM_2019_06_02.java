class TimeValue {
    public String value;
    public int timestamp;
    public TimeValue(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    private Map<String, List<TimeValue>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimeValue> values = map.getOrDefault(key, new ArrayList<>());
        values.add(new TimeValue(value, timestamp));
        map.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        List<TimeValue> values = map.getOrDefault(key, new ArrayList<>());
        TimeValue last = null;
        for(int i = 0; i < values.size(); i++) {
            TimeValue item = values.get(i);
            if(item.timestamp <= timestamp) last = item;
        }
                                                  
        return last == null ? "" : last.value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
