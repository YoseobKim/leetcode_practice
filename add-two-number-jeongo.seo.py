class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        def get_string_val(l):
            val=''
            while(True):
                val = str(l.val) + val
                if l.next is not None:
                    l = l.next
                else:
                    break
            return val
        val1 = get_string_val(l1)
        val2 = get_string_val(l2)
        ret = str(int(val1) + int(val2))
        llist=None
        for n in range(len(ret)):
            if n == 0:
                llist = ListNode(int(ret[len(ret) - n -1]))
            else:
                tmp=llist
                while(True):
                    if tmp.next is None:
                        break
                    else:
                        tmp = tmp.next
                tmp.next = ListNode(int(ret[len(ret) - n -1]))
                
        return llist
