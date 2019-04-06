class Solution {
    public String addBinary(String a, String b) {
        String ret = "";
        int carry = 0;
        int i = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int t = a.length() - 1; t >= 0; t--)
        {
            sb.append(a.charAt(t));
        }
        a = sb.toString();
        
        StringBuilder sb2 = new StringBuilder();
        
        for(int t = b.length() - 1; t >= 0; t--)
        {
            sb2.append(b.charAt(t));
        }
        b = sb2.toString();
        
        while(i < a.length() && i < b.length()) {
            int num1 = a.charAt(i) - '0';
            int num2 = b.charAt(i) - '0';
            int sum = num1 + num2 + carry;
            //System.out.println(num1 + " + " + num2 + " + " + carry + " = " + sum);
            int val = sum % 2;
            carry = sum / 2;
            ret = val + ret;
            i++;
        }
        
        if(i < a.length()) {
            // treat remain a
            for(int aIdx = i; aIdx < a.length(); aIdx++) {
                int num = a.charAt(aIdx) - '0';
                int sum = num + carry;
                int val = sum % 2;
                carry = sum / 2;
                ret = val + ret;
            }
        } else if(i < b.length()) {
            // treat remain b
            for(int bIdx = i; bIdx < b.length(); bIdx++) {
                int num = b.charAt(bIdx) - '0';
                int sum = num + carry;
                int val = sum % 2;
                carry = sum / 2;
                ret = val + ret;
            }
        }
        
        if(carry == 1) ret = carry + ret;
        
        return ret;
    }
}
