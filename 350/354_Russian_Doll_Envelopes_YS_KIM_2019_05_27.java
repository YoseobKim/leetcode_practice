class Envelope {
    public int w;
    public int h;
    public Envelope(int w, int h) {
        this.w = w;
        this.h = h;
    }
}

class EnvelopeComparator implements Comparator<Envelope> {
    // sort using width
    @Override
    public int compare(Envelope e1, Envelope e2) {
        return e2.w - e1.w;
    }
}

class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    
    private int maxEnvelopesHelper(List<Envelope> list, int index) {
        if(index < list.size()) {
            if(memo.containsKey(index)) return memo.get(index);
            Envelope bottom = list.get(index);
            int max = 0;
            for(int i = index + 1; i < list.size(); i++) {
                Envelope item = list.get(i);
                if(bottom.h > item.h && bottom.w > item.w)
                    max = Math.max(max, maxEnvelopesHelper(list, i));
            }
            max++;
            memo.put(index, max);
            return max;
        }
        return 0;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        int ret = 0;
        
        List<Envelope> helperList = new ArrayList<>();
        for(int i = 0; i < envelopes.length; i++) {
            helperList.add(new Envelope(envelopes[i][0], envelopes[i][1]));
        }
        Collections.sort(helperList, new EnvelopeComparator());
        
        int max = 0;
        for(int i = 0; i < helperList.size(); i++) {
            max = Math.max(max, maxEnvelopesHelper(helperList, i));
        }
        
        return max;
    }
}
