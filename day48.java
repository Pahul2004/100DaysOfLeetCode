// maximum path sum
class Solution {
    public int maxPathSum(TreeNode root) {
        int[]maxi=new int[1];
        maxi[0]=Integer.MIN_VALUE;
        helper(root,maxi);
        return maxi[0];
    }
    static int helper(TreeNode root,int[]maxi)
    {
        if(root==null)return 0;
        /* left & right subtrees ke liye sum calculate kiya
         (compared with 0 to ignore the -ve values)
        */
        int leftSum=Math.max(0,helper(root.left,maxi));
        int rightSum=Math.max(0,helper(root.right,maxi));
        // update maxi if current path sum(left+right+root) is greater
        maxi[0]=Math.max(maxi[0],leftSum+rightSum+root.val);
        // current node ke liye max path will be the greater from left and right plus the root value
        return Math.max(leftSum,rightSum)+root.val;
    }
}

// sum root to leaf numbers
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    static int helper(TreeNode root,int currentSum)
    {
        if(root==null)return 0;
        // calculate the currentSum
        currentSum=currentSum*10+root.val;
        // if we hit the leaf node then return the currentSum
        if(root.left==null && root.right==null)return currentSum;
        // recursively calculate the sum in left and right subtree
        return helper(root.left,currentSum)+helper(root.right,currentSum);
    }
}