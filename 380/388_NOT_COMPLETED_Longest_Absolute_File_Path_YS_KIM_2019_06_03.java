class Solution {
    private String lengthLongestPathHelper(String[] arr, int index, int prevNumOfTab, String prev) {
        if(arr.length > index) {
            String item = arr[index];
            int numOfTab = item.lastIndexOf("\t") + 1; // number of "\t"
            //System.out.println(item + " : " + numOfTab + " : " + prev + " : " + prevNumOfTab);
            if(item.contains(".")) {
                return prev + item;
            }
            if(prevNumOfTab + 1 == numOfTab) {
                String next = lengthLongestPathHelper(arr, index + 1, numOfTab, prev + item);
                //System.out.println("=>" + next);
                return next.length() != 0 ? next : prev + item;
            }
            
            return prev;
        }
        return "";
    }
    
    public int lengthLongestPath(String input) {
        String[] splitted = input.split("\n");
        if(splitted != null && splitted.length > 1) {
            String longest = "";
            for(int i = 1; i < splitted.length; i++) {
                String path = lengthLongestPathHelper(splitted, i, 0, splitted[0]);
                if(!path.contains(".")) continue;
                if(longest.length() < path.length()) longest = path;
                //System.out.println("====>" + path);
            }
            int len = 0;
            String[] retHelper = longest.split("\t");
            if(retHelper != null && retHelper.length > 1) {
                for(String s : retHelper) {
                    if(!s.isEmpty()) len += s.length() + 1;
                }
            } else {
                return longest.length();
            }
            return len - 1;
        }
        return input.contains(".") ? input.length() : 0;
    }
}
