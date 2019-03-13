class Solution:
    def intToRoman(self, num: int) -> str:
        dict1 = {0:'', 1:'I', 2:'II', 3:'III', 4:'IV', 5:'V', 6:'VI', 7:'VII', 8:'VIII', 9:'IX'}
        dict10 = {0:'', 1:'X', 2:'XX', 3:'XXX', 4:'XL', 5:'L', 6:'LX', 7:'LXX', 8:'LXXX', 9:'XC'}
        dict100 = {0:'', 1:'C', 2:'CC', 3:'CCC', 4:'CD', 5:'D', 6:'DC', 7:'DCC', 8:'DCCC', 9:'CM'}
        dict1000 = {0:'', 1:'M',2:'MM',3:'MMM'}
              
        u=dict1[num%10]
        d=dict10[int((num/10)%10)]
        h=dict100[int((num/100)%10)]
        t=dict1000[int((num/1000)%10)]
       
        return t+h+d+u
