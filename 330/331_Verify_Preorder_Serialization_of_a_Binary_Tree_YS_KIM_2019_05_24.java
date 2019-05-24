class Solution {
    private int index = 0;
    
    private boolean isValidSerializationHelper(String[] preorder, String parent) {
        if(index == preorder.length - 1) {
            index++;
            return true;
        }
        if(index < preorder.length) {
            if(parent.equals("#")) return false;
            String me = preorder[index++];
//            System.out.println(index + " : " + me);
            if(me.equals("#")) return true;
            // left
            boolean ret = isValidSerializationHelper(preorder, me);
            // right
            ret &= isValidSerializationHelper(preorder, me);
            return ret;
        }
        return false;
    }
    
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#")) return true;
        if(preorder.length() <= 1) return false;
        if(!preorder.contains(",")) return false;
        String[] items = preorder.split(",");
//        System.out.println(items.length);
        if(items == null || items.length <= 0) return false;
        index = 0;
        boolean ret = isValidSerializationHelper(items, items[0]);
//        System.out.println(index + " : " + items.length);
        return ret & index == items.length;
    }
}
