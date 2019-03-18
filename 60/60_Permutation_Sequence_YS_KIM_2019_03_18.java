class Solution {
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int decreasingIdx = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            if(num < nums[i + 1]) {
                decreasingIdx = i;
                break;
            }
        }

        int nextNumIdx = nums.length - 1;
        for(int i = decreasingIdx + 1; i < nums.length; i++) {
            if(nums[decreasingIdx] >= nums[i]) {
                nextNumIdx = i - 1;
                break;
            }
        }

        swap(nums, decreasingIdx, nextNumIdx);
        if(decreasingIdx != nextNumIdx)
            reverse(nums, decreasingIdx + 1);
        else
            reverse(nums, 0);
        return;
    }
    
    public List<List<Character>> permute(int n) {
        List<List<Character>> ret = new ArrayList<>();
        if(n <= 1) {
            List<Character> list = new ArrayList<>();
            list.add('1');
            ret.add(list);
            return ret;
        }

        List<List<Character>> prev = permute(n - 1);
        for(List<Character> list : prev) {
            for(int i = 0; i < n; i++) {
                List<Character> newList = new ArrayList<>(n);
                newList.addAll(list);
                newList.add(i, String.valueOf(n).charAt(0));
                ret.add(newList);
            }
        }
        return ret;
    }
    
    public String getPermutation(int n, int k) {
        if(n <= 0) return "";
        if(k <= 0) return "";
        int[] initial = new int[n];
        
        for(int i = 0, num = 1; i < n; i++, num++) {
            initial[i] = num;
        }
        
        for(int i = 1; i < k; i++) {
            nextPermutation(initial);
        }
        
      	StringBuilder sb = new StringBuilder();

        for(int i = 0; i < initial.length; i++) {
            sb.append(String.valueOf(initial[i]).charAt(0));
        }
        
        return sb.toString();
    }
}
