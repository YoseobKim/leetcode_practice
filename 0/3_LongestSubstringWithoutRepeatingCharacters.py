class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_val=1
        for i in range(len(s)):
            result=''
            for j in range(i,len(s)):
                if s[j] not in result:
                    result +=s[j]
                else:
                    break
                    
            if len(result) > max_val:
                max_val=len(result)
                print(max_val)
                
        return max_val
