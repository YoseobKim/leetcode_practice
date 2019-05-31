class RandomizedSet {
    private Set<Integer> randomSet = null;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        randomSet = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return randomSet.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(randomSet.contains(val)) {
            randomSet.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int loop = (int)(Math.random() * randomSet.size());
        int count = 0;
        Iterator<Integer> iterator = randomSet.iterator();
        while(count < loop) {
            iterator.next();
            count++;
        }
        return iterator.next();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
