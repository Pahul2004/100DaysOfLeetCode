// remove duplicates from sorted list 2
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while(head!=null)
        {
            if(head.next!=null && head.val==head.next.val)
            {
                while(head.next!=null && head.val==head.next.val)
                {
                    head=head.next;
                }
                prev.next=head.next;
            }
            else
            {
                prev=prev.next;
            }
            head=head.next;
        }
        return dummy.next;
    }
}

// add two numbers 2
class Solution {
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        while(head!=null)
        {
            ListNode nextNode=head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        return prev;
    }
    public ListNode addReversedList(ListNode l1,ListNode l2)
    {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       l1=reverse(l1);
       l2=reverse(l2);
       ListNode result=addReversedList(l1,l2);
       return reverse(result);
    }
}