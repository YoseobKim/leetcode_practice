import java.math.BigInteger; 

// Too many edge cases!!!!

class Solution {
    public boolean isNum(char c) {
        int asciiCode = (int) c;
        return (asciiCode >= 48 && asciiCode <= 57);
    }
    
    public boolean isMinus(char c) {
        int asciiCode = (int) c;
        return asciiCode == 45;
    }
    
    public boolean isPlus(char c) {
        int asciiCode = (int) c;
        return asciiCode == 43;
    }
    
    public int myAtoi(String str) {
        char[] sArr = str.toCharArray();
        boolean first = true;
        int start = 0;
        int end = str.length() - 1;

        int digit = 1;
        boolean isMinus = false;
        boolean isPlus = false;
        
        for(int i = 0; i < str.length(); i++) {
            char c = sArr[i];
            if(first && (c == ' ' || c == '0')) continue; // do not process ' ' || '0' following the instruction
            if(first && !(isNum(c) || isMinus(c) || isPlus(c))) {
                return 0; // the string does not starts with integer
            }
            if(isPlus && isPlus(c)) {
                if(first) return 0;
                else {
                    end = i;
                    break;
                }
            }
            if(first && isPlus(c)) {
                isPlus = true;
                continue;
            }
            if(isMinus && isMinus(c)) {
                if(first) return 0;
                else {
                    end = i;
                    break;
                }
            }
            if(first && isMinus(c)) {
                isMinus = true;
                continue;
            }
            if(!isNum(c)) {
                end = i; // it will be the last digit
                break;
            }
            if(first) {
                start = i;
                first = false;
                continue;
            }
            digit *= 10;
            // Overflow!!
            if(digit < 0) return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        boolean overflow = false;
        int calc = 0;
        // edge case. There is no number in str.
        if(first) return 0;
        // edge case. Confusing sign signal.
        if(isMinus && isPlus) return 0;
        // edge case. Digit. Maybe overflow.
        if(digit != 1 && digit % 10 != 0) return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;


        for(int i = start; i <= end; i++) {
            // edge case
            if((isMinus(sArr[start]) || isPlus(sArr[start])) && start == end) return 0;
            char c = sArr[i];

            int num = ((int)c - 48);
            calc = calc + (num * digit);

            // overflow!
            if(calc < 0) {
                overflow = true;
                break;
            }
            // overflow!
            if(digit > 0 && num != num * digit / digit) {
                overflow = true;
                break;
            }
            
            digit /= 10;
        }
        // edge case. 0, signs and blank
        if(str.contains("0 ") || str.contains("- ") || str.contains("+ ") 
           || str.contains("0-") || str.contains("0+")) return 0;

        
        if(overflow) {
            return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return isMinus ? -calc : calc;
    }
}
