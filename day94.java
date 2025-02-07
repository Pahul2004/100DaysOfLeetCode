// remove nth node from the end of the list
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=dummy;
        ListNode second=dummy;
        // move the first pointer n+1 steps ahead
        for(int i=0;i<=n;i++)
        {
            if(first==null)return null;
            first=first.next;
        }
        // move both pointers until first reaches the end of list
        while(first!=null)
        {
            first=first.next;
            second=second.next;
        }
        // now second is at previous of nth node from end , remove it
        second.next=second.next.next;
        return dummy.next;
    }
}

// tuple with same product
class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int count=0;
        // store product frequencies
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int product=nums[i]*nums[j];
                map.put(product,map.getOrDefault(product,0)+1);
            }
        }
        for(int freq:map.values())
        {
            if(freq>1)
            {
                count+=(freq*(freq-1))/2*8;
            }
        }
        return count;
    }
}
