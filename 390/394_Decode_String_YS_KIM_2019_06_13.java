import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    private static String decodeHelper(String s) {
        String[] splitted = s.split("\\[");
        int num = Integer.parseInt(splitted[0]);
        String str = splitted[1].replace("]","");
        String ret = "";
        for(int i = 0; i < num; i++) {
          ret += str;
        }
        return ret;
    }
    
    public String decodeString(String s) {
        // Example strings
        // "3[a]2[bc]"
        // "100[leetcode]"
        // "3[a]2[b4[F]c]"
        // This pattern will find \d+\[[a-zA-Z]*\]
        String patternStr = "\\d+\\[[a-zA-Z]*\\]";
        Pattern pattern = Pattern.compile(patternStr);

        // This while loop will process any string that can match patern.
        // and If there is no more, then break.
        // "3[a]2[b4[F]c]"
        // 1. process 3[a] and 4[F] first and decode it.
        // 2. aaa2[bFFFFc] -> will be processed as normal.
        while (true) {
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()) {
                String compressedItem = matcher.group();
            	String decompressed = decodeHelper(compressedItem);
                s = s.replace(compressedItem, decompressed);
            }a
            else break;
        }
      
        //System.out.println(s);
        return s;
    }
}
