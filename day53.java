// convert bst to a greater tree
class Solution {
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    private void helper(TreeNode root)
    {
        if(root==null)return ;
        // reverse inorder traversal right->node->left
        helper(root.right);
        sum+=root.val;
        root.val=sum;
        helper(root.left);
    }
}

// diameter of binary tree
class Solution {
    private int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }
    private int calculateHeight(TreeNode root)
    {
        if(root==null)return 0;
        int leftHeight=calculateHeight(root.left);
        int rightHeight=calculateHeight(root.right);
        diameter=Math.max(diameter,leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
}