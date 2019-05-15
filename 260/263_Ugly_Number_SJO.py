# 기본적으로 recursive로 풀되, 탈출조건으로 2,3,5에 해당하지 않는수 (7,13,11)로 체크해서 나누어 지면 바로 False 반환하여 처리함 

class Solution:
    def solve(self, num):
        if num == 1  :
            return True
        ret = True
        
        if num%7 ==0 or num%13 ==0 or num%11 == 0:
            return False
        if num%2 == 0:
            ret = self.solve(num/2)
        elif num%3 == 0:
            ret = self.solve(num/3)
        elif num%5 == 0:
            ret = self.solve(num/5)
        else:
            ret = False
            print('aaa')
        return ret
    def isUgly(self, num: int) -> bool:
        tmp = num
        if tmp == 1:
            return True
        ret = self.solve(tmp)
        return ret
