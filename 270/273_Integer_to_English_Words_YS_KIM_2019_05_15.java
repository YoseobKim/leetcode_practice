class Solution {
    private String[] thousandExpressions = {
        "", "Thousand", "Million", "Billion"
    };
    
    private String[] tenthExpressions = {
        "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    
    private String[] lessThanTwentyExpressions = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    
    private String digitToEnglish(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return lessThanTwentyExpressions[num] + " ";
        else if (num < 100)
            return tenthExpressions[num / 10] + " " + (num % 10 == 0 ? "" : lessThanTwentyExpressions[num % 10] + " ");
        else
            return lessThanTwentyExpressions[num / 100] + " Hundred " + digitToEnglish(num % 100);
    }
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 0;
        String words = "";
    
        while (num > 0) {
            // use three digits to make string (hundreds)
            if (num % 1000 != 0) {
                // first thousand expression is ""
                // after that thousand, million, hundred...
    	        words = digitToEnglish(num % 1000) + thousandExpressions[i] + " " + words;
            }
            // remove last three digits
    	    num /= 1000;
    	    i++;
        }
    
        return words.trim();
    }
}
