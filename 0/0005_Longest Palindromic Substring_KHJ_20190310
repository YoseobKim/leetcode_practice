class Solution {
public:
    string longestPalindrome(string s) {
        int longest_head = 0, longest_tail = 0;
        
        for (int i = 0 ; i < s.size() ; i++) {
            for (int j = s.size() - 1 ; j > 0 ; j--) {
                if (isPalindrome(s, i, j)) {                    
                    if (j - i > longest_tail - longest_head) {                        
                        longest_head = i;
                        longest_tail = j;
                        break;
                    }
                }
            }
        }        
        
        return s.substr(longest_head, longest_tail - longest_head + 1);
    }
    
    bool isPalindrome(string& s, int head, int tail) {
        while (head <= head + (tail - head) / 2) {
            if (s[head++] != s[tail--])
                return false;
        }
        
        return true;
    }
};
