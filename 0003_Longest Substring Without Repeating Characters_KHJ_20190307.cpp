class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.size() < 2) 
            return s.size();
        
        int longest = 1;        
        
        int i = 0, j = 1;
        
        while (i < s.size() && j < s.size()) {
            if (!check(s, i, j))
                j++;
            else            
                i++;
            
            longest = j-i > longest ? j-i : longest;
        }
        
        return longest;
    }
    
    bool check(string& s, int index_i, int index_j) {
        while (index_i < index_j) {
            if (s[index_i] == s[index_j])
                return true;
            
            index_i++;
        }
        return false;
    }
};
