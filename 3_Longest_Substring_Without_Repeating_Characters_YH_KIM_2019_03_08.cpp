class Solution {
public:
    int lengthOfLongestSubstring(string s) 
    {
        int longest = 0;
        int index = 0;
        int map_index = 0;
        
        std::set<char> char_map;

        for(int i = 0; i < s.length(); ++i)
        {
            auto res = char_map.insert(s[i]);
            if(res.second == false)
            {
                longest = max(longest, (int)char_map.size());
                char_map.clear();
                char target = s[i];
                while(s[--i] != target);
            }
        }
        
        longest = max(longest, (int)char_map.size());
        
        return longest;
    }
};
