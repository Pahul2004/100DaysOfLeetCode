// Lowest Common Ancestor of a Binary Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)return root;
        TreeNode leftLCA=lowestCommonAncestor(root.left,p,q);
        TreeNode rightLCA=lowestCommonAncestor(root.right,p,q);
        if(leftLCA!=null && rightLCA!=null)return root;
        return (leftLCA!=null)?leftLCA:rightLCA;
    }
}

// Lowest Common Ancestor of a Binary Search Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return root;
        // if both p and q are smaller than the root node then the lca in the left subtree
        if(p.val<root.val && q.val<root.val)return lowestCommonAncestor(root.left,p,q);
        // if both p and q are larger than the root node then the lca is in the right subtree 
        if(p.val>root.val && q.val>root.val)return lowestCommonAncestor(root.right,p,q);
        // if one value is smaller and other one is larger then the lca is the current root
        return root;
    }
}