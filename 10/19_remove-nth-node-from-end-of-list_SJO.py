# 로직은 간단함 일단 리스트의 사이즈를 구하고, 그후 해당 위치의 앞에서 그 다음다음과연결함 
# 하지만 위치가 제일 앞일 경우는 예외 처리가 필요함 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        anchor=head
        cnt = 1 
        while(True):
            if anchor.next==None:
                break
            else:
                anchor = anchor.next
                cnt +=1
        anchor=head
        for _ in range(cnt-n-1):
            anchor = anchor.next
        
        print(n, cnt)
        if n==cnt:
            if head.next:
                return head.next
            else:
                return None
        
        anchor.next = anchor.next.next
        return head
