/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
              
        ListNode *ret_head, *ret_ptr;
        
        ListNode *l1_ptr, *l2_ptr;
                
        int sum = 0;
        int digit = 0;
        int upperbit = 0;
        
        ret_head = new ListNode(upperbit);
        ret_ptr = ret_head;
        
        for(l1_ptr = l1, l2_ptr = l2; (l1_ptr || l2_ptr); )
        { 
            sum = (l1_ptr ? l1_ptr->val : 0) + (l2_ptr ? l2_ptr->val : 0) + ret_ptr->val;
            digit = (sum >= 10) ?  sum - 10 : sum;
            upperbit = (sum >= 10) ? 1 : 0;
            
            ret_ptr->val = digit;
            if( (l1_ptr && l1_ptr->next) || (l2_ptr && l2_ptr->next) || upperbit)
            {
                ret_ptr->next = new ListNode(upperbit);
                ret_ptr = ret_ptr->next;
            }
            l1_ptr = l1_ptr? l1_ptr->next : nullptr;
            l2_ptr = l2_ptr? l2_ptr->next : nullptr;
        }
       
        return ret_head;
    }
};
