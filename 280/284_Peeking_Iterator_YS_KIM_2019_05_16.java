// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator_ = null;
    private int prev = 0;
    private boolean iteratorFinished1 = false;
    private boolean iteratorFinished2 = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iterator_ = iterator;
        prev = iterator_.hasNext() ? iterator_.next() : 0;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return prev;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int ret = prev;
        if(!iteratorFinished1) {
            prev = iterator_.next();
            iteratorFinished1 = !iterator_.hasNext();
        } else {
            iteratorFinished2 = true;
        }
        return ret;
	}

	@Override
	public boolean hasNext() {
	    return !iteratorFinished2;
	}
}
