class Solution {
    public boolean isNumber(String s) {
        if(s.length() <= 0) return false;
        String trimed = s.trim();
        if(trimed.length() <= 0) return false;
        boolean hasMinus = trimed.charAt(0) == '+' ? true : false;
        boolean hasPlus = trimed.charAt(0) == '-' ? true : false;
        int start = 0;
        if(hasMinus || hasPlus) {
            // have sign signal and it must be the first index.
            start = 1;
        }
        
        boolean dot_started = false;
        boolean e_started = false;
        boolean number_started = false;
        for(int i = start; i < trimed.length(); i++) {
            char c = trimed.charAt(i);
            int code = (int)c;

            // number area
            if(c >= 48 && c <= 57) {
                number_started = true;
                continue;
            } else {
                // strange edgecases that found from submissions.
                // edge case ".1" is valid? -> YES. In test scenario, .1 .2 .3 these kind of things are also valid.
                // edge case "3." is valid? -> YES. In test scenario, 3. 2. 1. these kind of things are also valid.
                // by following the edge cases above, "." can be valid? => NO.
                // somehow "-.", "+." these kind of things are also not valid.
                // very very strangely, "." cannot be valid.
                if(c == '.') {
                    String substring = hasMinus || hasPlus ? trimed.substring(1) : trimed;
                    // but if dot already exists in front of the string? not valid.
                    if(dot_started) return false;
                    // dot cannot come after e
                    if(e_started) return false;
                    dot_started = true;
                    if(substring.equals(".") || trimed.equals(".")) return false;

                    continue;
                }
                // if any none number char exists the last? not valid.
                if(i == trimed.length() - 1) return false;
                
                // not number also can come if before char was a integer
                // such as dot or e
                if(number_started) {
                    if(c == '.') {
                        // but if dot already exists in front of the string? not valid.
                        if(dot_started) return false;
                        // dot cannot come after e
                        if(e_started) return false;
                        dot_started = true;
                        continue;
                    } else if(c == 'e') {
                        // but if e already exists in front of the string? not valid.
                        if(e_started) return false;
                        e_started = true;
                        // e can have sign char right after e. in that case treat it in advance.
                        char maybesign = trimed.charAt(i + 1);
                        if(maybesign == '-' || maybesign == '+') {
                            i++;
                        }
                        if(i >= trimed.length() - 1) return false;

                        continue;
                    }
                }
                
                return false;
            }
        }
        return true;
    }
}
