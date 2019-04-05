class Solution {
    public int romanToInt(String s) {
        char[] sArr = s.toCharArray();
        int ret = 0;
        
        for(int i = 0; i < sArr.length; i++) {
            char cur = sArr[i];
            char next = i + 1 >= sArr.length ? '.' : sArr[i + 1];
            if(cur == 'I') {
                if(next == 'V') {
                    i++;
                    ret += 4;
                }
                else if(next == 'X') {
                    i++;
                    ret += 9;
                } else {
                    ret += 1;
                }
            } else if(cur == 'V') {
                ret += 5;
            } else if(cur == 'X') {
                if(next == 'L') {
                    i++;
                    ret += 40;
                } else if(next == 'C') {
                    i++;
                    ret += 90;
                } else {
                    ret += 10;
                }
            } else if(cur == 'L') {
                ret += 50;
            } else if(cur == 'C') {
                if(next == 'D') {
                    i++;
                    ret += 400;
                } else if(next == 'M') {
                    i++;
                    ret += 900;
                } else {
                    ret += 100;
                }
            } else if(cur == 'D') {
                ret += 500;
            } else if(cur == 'M') {
                ret += 1000;
            } else {
                System.out.println("Unknown : " + cur);
            }
        }
        return ret;
    }
}
