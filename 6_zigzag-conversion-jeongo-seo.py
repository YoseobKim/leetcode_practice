class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows ==1:
            return s
        ret=[[]for _ in range(numRows)]
        for n, i in enumerate(s):
            which_order = n%(2*numRows - 2)
            if which_order <numRows:
                ret[which_order].append(i)
            else:
                ret[2*(numRows -1) - which_order ].append(i)
        ret_str=''
        for i in ret:
            ret_str += ''.join(i)
            
        return ret_str
