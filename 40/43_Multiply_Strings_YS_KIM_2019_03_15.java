class Solution {
    // get 2 strings and add them and return as a string.
    private String sum2Strings(String num1, String num2) {
        if(num1.length() <= 0) return num2;
        if(num2.length() <= 0) return num1;

        String ret = "";
        int diff = num1.length() - num2.length();
        
        // if length is different, add 0s for easier calculation and loop control.
        if(diff > 0) {
            // num1 len is longer than num2 len.
            String zeros = "";
            for(int i = 0; i < diff; i++) {
                zeros += "0";
            }
            num2 = zeros + num2; // add 0s in front of num2 string
        } else if (diff < 0){
            // num2 len is longer than num1 len.
            String zeros = "";
            diff = -diff;
            for(int i = 0; i < diff; i++) {
                zeros += "0";
            }
            num1 = zeros + num1; // add 0s in front of num1 string
        }
        // length of num1 and num2 will be same.
        
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        int carry = 0;
        
        // from end to first
        // "231"
        //  012
        // should treat from index number 2 as it is LSD(least significant digit).
        for(int i = num1Arr.length - 1; i >= 0; i--) {
            char num1Char = num1Arr[i];
            char num2Char = num2Arr[i];
            int num1Int = charToInt(num1Char);
            int num2Int = charToInt(num2Char);
            int sum = num1Int + num2Int + carry;
            carry = sum / 10;
            int remain = sum % 10;
            ret = intToChar(remain) + ret; 
        }
        // carry should be added on the first of the string.
        if(carry > 0) {
            ret = carry + ret;
        }
        
        return ret;
    }
    
    // multiply num1 * num2 but num2 is single digit number and num1 is a string.
    private String multiplyStringAndInt(String num1, int num2) {
        char[] num1Arr = num1.toCharArray();
        int carry = 0;
        String ret = "";
        
        // from end to first.
        for(int i = num1Arr.length - 1; i >= 0; i--) {
            char num1Char = num1Arr[i];
            int num1Int = charToInt(num1Char);

            int mulForThisDigit = num1Int * num2 + carry;
            carry = mulForThisDigit / 10;
            int remain = carry > 0 ? mulForThisDigit - (carry * 10) : mulForThisDigit;
            // actually same with carry % 10;
            ret = intToChar(remain) + ret;
        }
        
        if(carry > 0) {
            ret = intToChar(carry) + ret;
        }
        
        return ret;
    }
    
    private char intToChar(int num) {
        return (char)(num + 48);
    }
    
    private int charToInt(char c) {
        return (int)c - 48;
    }
    
    public String multiply(String num1, String num2) {
        // special cases.
        if(num2.length() <= 1) {
            if(num2.contains("0")) return "0";
            else if(num2.contains("1")) return num1;
        }
        if(num1.length() <= 1) {
            if(num1.contains("0")) return "0";
            else if(num1.contains("1")) return num2;
        }
        char[] num2Arr = num2.toCharArray();

        String digitStr = "";
        String ret = "";
        boolean isNum1Minus = num1.charAt(0) == '-' ? true : false;
        boolean isNum2Minus = num2.charAt(0) == '-' ? true : false;
        boolean isResultMinus = isNum1Minus ^ isNum2Minus;
        // if isNum1Minus XOR isNum2Minus is true, then we need to add "-" at the begining of the return.
        int firstNum2Index = isNum2Minus ? 1 : 0; // if minus, index should start from 1
        String num1Copy = isNum1Minus ? num1.substring(1) : num1; 
        // if minus, substring from 1 as the first index is bit character.

        for(int i = num2Arr.length - 1; i >= firstNum2Index; i--) {
            char num2Char = num2Arr[i];
            int num2Int = charToInt(num2Char);
            
            String mul = multiplyStringAndInt(num1Copy, num2Int) + digitStr;
            ret = sum2Strings(ret, mul);

            digitStr += "0";
        }
        
        return isResultMinus ? "-" + ret : ret;
    }
}
