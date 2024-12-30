// recover binary search tree
class Solution {
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE); // store the previous node during inorder traversal
    public void recoverTree(TreeNode root) {
        // perform inorder traversal to find the 2 swapped nodes
        inorder(root);
        //swap the values of 2 misplaced nodes
        if(first!=null && second!=null)
        {
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
    private void inorder(TreeNode root)
    {
        if(root==null)return ;
        // traverse left subtree
        inorder(root.left);
        // identify misplaced nodes
        if(prev.val>root.val)
        {
            if(first==null)first=prev; // first misplaced node
            second=root; // second misplaced node
        }
        prev=root; // update the previous node
        inorder(root.right); // traverse the right subtree
    }
}

// trim a bst
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)return null; // if node is null return null
        // if current node's value is less than the lower boundary then skip the left subtree
        if(root.val<low)return trimBST(root.right,low,high);
        // if current node's value is greater than the higher boundary then skip the right subtree 
        if(root.val>high)return trimBST(root.left,low,high);
        // recursively trim the left and right subtrees
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }
}