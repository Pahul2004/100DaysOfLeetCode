// re3emove duplicates from sorted list
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode curr=head;
        while(curr!=null && curr.next!=null)
        {
            if(curr.val==curr.next.val)
            {
                ListNode temp=curr.next;
                curr.next=curr.next.next;
                temp.next=null;
            }
            else
            {
                curr=curr.next;
            }
        }
        return head;
    }
}

// merge two sorted lists
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                temp.next=list1;
                list1=list1.next;
            }
            else
            {
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1!=null)temp.next=list1;
        if(list2!=null)temp.next=list2;
        return dummy.next;
    }
}