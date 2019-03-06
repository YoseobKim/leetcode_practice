class Solution:
    def myAtoi(self, str: str) -> int:
        ret_val=0
        while(True):
            if str is '':
                return ret_val
            if str[0] == ' ':
                str=str[1:]
            else:
                break
        minus_flag=False
        if str[0] == '-':
            minus_flag=True
            str=str[1:]
        elif str[0] == '+':
            str=str[1:]
        base='0123456789'
        pos=-1
        for n,i in enumerate(str):
            if i not in base:
                break
            else:
                pos=n
                
        INT_MAX=2**31-1
        INT_MIN=-2**31
        if pos == -1:
            return ret_val
        else:
            if minus_flag:
                ret_val=int('-'+str[:pos+1])
                if ret_val > INT_MIN:
                    return ret_val
                else:
                    return INT_MIN
            else:
                ret_val = int(str[:pos+1])
                if ret_val < INT_MAX:
                    return ret_val
                else:
                    return INT_MAX
