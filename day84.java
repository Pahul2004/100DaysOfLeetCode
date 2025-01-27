// path sum
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        if(root.left==null && root.right==null && root.val==targetSum)return true;
        int remainingSum=targetSum-root.val;
        return hasPathSum(root.left,remainingSum) || hasPathSum(root.right,remainingSum);
    }
}

// Populating Next Right Pointers in Each Node
class Solution {
    public Node connect(Node root) {
        if(root==null)return null;
        // start with root node
        Node levelStart=root;
        while(levelStart.left!=null)
        {
            Node current=levelStart;

            // traverse the current level and set up the next pointers for next level
            while(current!=null)
            {
                current.left.next=current.right;
                if(current.next!=null)
                {
                    current.right.next=current.next.left;
                }
                current=current.next;
            }
            // move to the next level
            levelStart=levelStart.left;
        }
        return root;
    }
}