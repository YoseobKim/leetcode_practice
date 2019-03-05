class Solution:
    def longestPalindrome(self, s: str) -> str:
        def checkPalindromic(candidate):
            ret=None
            n_c = len(candidate)
            if n_c == 1:
                ret=True
                return ret

            if n_c % 2 == 1:
                for i in range(int(n_c/2)):
                    if candidate[i]==candidate[n_c-i-1]:
                        ret=True
                    else:
                        ret=False
                        break
            else : 
                for i in range(int(n_c/2)):
                    if candidate[i]==candidate[n_c-i-1]:
                        ret=True
                    else:
                        ret=False
                        break
            return ret
        
        ret_str=''
        for i in range(len(s)):
            n=len(s)-i-1
            for j in range(len(s)):
                if j+n+1 > len(s):
                    break
                if checkPalindromic(s[j:j+n+1]) :
                    return s[j:j+n+1]
                    
        return ret_str[0]
