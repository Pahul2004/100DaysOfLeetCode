// convert sorted list to binary search tree
class Solution {
    private ListNode head;
    public int length(ListNode head)
    {
        int length=0;
        while(head!=null)
        {
            length++;
            head=head.next;
        }
        return length;
    }
    public TreeNode sortedListToBST(ListNode head) {
        this.head=head;
        int size=length(head);
        return convert(0,size-1);
    }
    public TreeNode convert(int left,int right)
    {
        if(left>right)return null;
        int mid=(left+right)/2;
        // recursively build left subtree
        TreeNode leftTree=convert(left,mid-1);
        // create root node with current linkedlist node
        TreeNode root=new TreeNode(head.val);
        root.left=leftTree; // connect the left subtree with the root node
        head=head.next; // move the head pointer to the next node
        // recursively build right subtree
        root.right=convert(mid+1,right);
        return root;
    }
}

// flatten binary tree
class Solution {
    private TreeNode prev;
    public void flatten(TreeNode root) {
        if(root==null)return ;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}