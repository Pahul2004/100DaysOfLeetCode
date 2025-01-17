// Count Good Nodes in Binary Tree
class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root,Integer.MIN_VALUE);
    }
    public int helper(TreeNode root,int maxSoFar)
    {
        if(root==null)return 0;
        int count=0;
        // if the current node's vvalue is greater than or equal to maxSoFar,it's a good node
        if(root.val>=maxSoFar)
        {
            count++;
            // update maxSoFar for child nodes
            maxSoFar=root.val;
        }
        // recursively count the good nodes in left and right subtrees
        count+=helper(root.left,maxSoFar);
        count+=helper(root.right,maxSoFar);
        return count;
    }
}

// delete middle node of a linked list
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null)
        {
            prev.next=slow.next;
        }
        return head;
    }
}