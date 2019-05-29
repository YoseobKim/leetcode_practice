class Pair {
    public int num1;
    public int num2;
    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    public int sum() {
        return num1 + num2;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        return p1.sum() - p2.sum();
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<Pair> helperList = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                helperList.add(new Pair(nums1[i], nums2[j]));
            }
        }
        Collections.sort(helperList, new PairComparator());
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < Math.min(k, helperList.size()); i++) {
            List<Integer> item = new ArrayList<>();
            item.add(helperList.get(i).num1);
            item.add(helperList.get(i).num2);
            ret.add(item);
        }
        return ret;
    }
}
