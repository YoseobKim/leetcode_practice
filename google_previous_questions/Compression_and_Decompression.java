import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestPatternMatcher {
    //private static String compressed = "3[abc]4[ab]c";
    private static String compressed = "2[3[a]b]";
    public static void main(String[] args) {
        String patternStr = "\\d\\[[a-z]*\\]";
        Pattern pattern = Pattern.compile(patternStr);

        while (true) {
            Matcher matcher = pattern.matcher(compressed);
            if(matcher.find()) {
                String compressedItem = matcher.group();
            	String decompressed = decompressHelper(compressedItem);
                compressed = compressed.replace(compressedItem, decompressed);
            }
            else break;
        }
      
        System.out.println(compressed);

    }
  
    private static String decompressHelper(String s) {
        String[] splitted = s.split("\\[");
        int num = Integer.parseInt(splitted[0]);
        String str = splitted[1].replace("]","");
        String ret = "";
        for(int i = 0; i < num; i++) {
          ret += str;
        }
        return ret;
    }
}
