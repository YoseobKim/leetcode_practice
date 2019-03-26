class Solution {
    private boolean isValid(String s) {
        if(s.length() > 3) return false;
        if(s.length() == 1) return true;
        if(s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        if(num > 255) return false;
        return true;
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if(s.length() < 4) return ret;
        for(int end1 = 1; end1 < 4 ; end1++) {
            int end2end = end1 + 4;
            for(int end2 = end1 + 1; end2 < end2end && end2 < s.length(); end2++) {
                int end3end = end2 + 4;
                for(int end3 = end2 + 1; end3 < end3end && end3 < s.length(); end3++) {
                    String s1 = s.substring(0, end1);
                    String s2 = s.substring(end1, end2);
                    String s3 = s.substring(end2, end3);
                    String s4 = s.substring(end3, s.length());
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        String ip = s1 + "." + s2 + "." + s3 + "." + s4;
//                        System.out.println(s1 + "." + s2 + "." + s3 + "." + s4);
                        ret.add(ip);
                    }
                }
            }
        }
        
        return ret;
    }
}
