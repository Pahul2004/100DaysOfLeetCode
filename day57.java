// minimum absolute difference 
class Solution {
    private Integer prev=null;
    private int minDiff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    private void inorder(TreeNode root)
    {
        if(root==null)return ;
        // traverse left subtree
        inorder(root.left);
        // calculate the difference with previous node
        if(prev!=null)
        {
            minDiff=Math.min(minDiff,root.val-prev);
        }
        // update previous node value
        prev=root.val;
        // traverse right subtree
        inorder(root.right);
    }
}

// deepest leaves sum
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int sum=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            sum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
        }
        return sum;
    }
}