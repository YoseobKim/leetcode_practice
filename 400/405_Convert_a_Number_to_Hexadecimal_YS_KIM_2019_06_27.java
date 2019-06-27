class Solution {
    private char[] hexMap = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = hexMap[(num & 15)] + result; 
            num = (num >>> 4); // shift 4 digits
        }
        return result;
    }
}
