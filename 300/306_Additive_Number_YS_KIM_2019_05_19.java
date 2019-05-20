class Solution {
    private String isAdditive(long num1, long num2, String sum) {
        if(sum.length() <= 0) return "";
        Long sumNum = num1 + num2;
        String sumStr = sumNum.toString();
//        System.out.println(num1 + " : " + num2 + " : " + sum);
        if(sum.startsWith(sumStr)) return sumStr;
        else return "";
    }
    
    public boolean isAdditiveNumber(String num) {
        if(num.length() <= 2) return false;
        int start = 0;
        
        for(int i = 1; i < num.length(); i++) {
            String num1Str = num.substring(start, i);
            if(num1Str.startsWith("0") && num1Str.length() > 1) continue;
            long num1 = Long.parseLong(num1Str);

            for(int j = i + 1; j <= num.length(); j++) {
                String num2Str = num.substring(i, j);
                if(num2Str.startsWith("0") && num2Str.length() > 1) break;
                long num2 = Long.parseLong(num2Str);
                String sum = num.substring(j);
                if(sum.startsWith("0") && sum.length() > 1) continue;
                String sumRes = isAdditive(num1, num2, sum);
                if(sumRes.length() > 0) {
                    // sumRes == sum means the string is finished
                    if(sumRes.equals(sum)) return true;
                    else {
                        boolean ret = isAdditiveNumber(num.substring(i));
                        if(ret) return true;
                    }
                }
            }
        }
        
        return false;
    }
}
