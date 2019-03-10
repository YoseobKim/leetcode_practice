class Solution {
public:
    string longestPalindrome(string s) {
        
        if(s.length() == 0)
            return s;
        
        int len = s.length();
        int max_len = 1;
        int start = 0;
        
        bool table[len][len] = {false};
        
        //all length 1, is palindromic
        for(int i = 0; i < len; ++i)
            table[i][i] = true;
        
        //all length 2, if same then palindromic
        for(int i = 0; i < len - 1; ++i)
        {
            if(s[i] == s[i+1])
            {
                table[i][i+1] = true;
                start = i;
                max_len = 2;
            }
        }
        
        for(int k = 3; k <= len; ++k)
        {
            for(int i = 0; i < len - k + 1; ++i)
            {
                int end = i + k - 1;
                
                if(table[i+1][end-1] && s[i] == s[end])
                {
                    table[i][end] = true;
                    
                    if(k > max_len)
                    {
                        start = i;
                        max_len = k;
                    }
                }
            }
        }
        
        string sub = s.substr(start, max_len);
        
        
        return sub;
    }
};
