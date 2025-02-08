// swap nodes in pairs
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while(prev.next!=null && prev.next.next!=null)
        {
            ListNode first=prev.next;
            ListNode second=prev.next.next;

            // swap nodes
            first.next=second.next;
            second.next=first;
            prev.next=second;

            // move prev to next pair
            prev=first;
        }
        return dummy.next;
    }
}

// add two numbers
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry>0)
        {
            int sum=carry;
            if(l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
        }
        return dummy.next;
    }
}