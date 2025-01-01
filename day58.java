// Second Minimum Node In a Binary Tree
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null || root.left==null || root.right==null)return -1;
        int leftVal=root.left.val;
        int rightVal=root.right.val;
        if(leftVal==root.val)leftVal=findSecondMinimumValue(root.left);
        if(rightVal==root.val)rightVal=findSecondMinimumValue(root.right);
        if(leftVal==-1)return rightVal;
        if(rightVal==-1)return leftVal;
        return Math.min(leftVal,rightVal);
    }
}

// Insert into a Binary Search Tree
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)return new TreeNode(val);
        if(val<root.val)root.left=insertIntoBST(root.left,val);
        else root.right=insertIntoBST(root.right,val);
        return root;
    }
}