class RandomizedCollection {
    private List<Integer> arr = new LinkedList<>();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(arr.contains(val)) {
            arr.add(val);
            return false;
        } else {
            arr.add(val);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        int index = arr.indexOf(val);
        if(index >= 0) {
            arr.remove(index);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int rand = (int)(Math.random() * arr.size());
        return arr.get(rand);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
