class Solution:
    def maxArea(self, height: List[int]) -> int:
        ret=0
        l=len(height)
        print(l)
        for i in range(l):
            for j in range(i+1,l):
                w=j-i
                h=min(height[i], height[j])
                tmp=w*h
                if tmp > ret:
                    ret=tmp
        return ret
