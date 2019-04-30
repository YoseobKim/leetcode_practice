class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        
        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
    
    public String fractionToDecimal2(int numerator, int denominator) {
        String ret = "";
        ret += numerator / denominator;
        if(numerator % denominator == 0) {
            return ret;
        }
        ret += ".";
        int prevRemain = numerator % denominator;

        numerator *= 10;
        boolean repeated = false;
        String rem = "";
        while(true) {
            rem += numerator / denominator;
            if(numerator % denominator == 0) break;
            int remain = numerator % denominator;
            numerator = (numerator % denominator) * 10;
            //System.out.println(rem + " : " + numerator);
            if(prevRemain == remain) {
                repeated = true;
                return ret + rem.substring(0, rem.length() - 1) + "(" + rem.charAt(rem.length() - 1) + ")";
            }
            prevRemain = remain;
            if(rem.length() % 2 == 0) {
                String first = rem.substring(0, rem.length() / 2);
                String second = rem.substring(rem.length() / 2);
                // System.out.println(first + " : " + second);
                if(first.equals(second)) {
                    repeated = true;
                    rem = second;
                    break;
                }
            }
        }
        
        return repeated ? ret + "(" + rem + ")" : ret + rem;
    }
}
