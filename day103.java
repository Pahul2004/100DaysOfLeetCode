// Construct Binary Tree from Preorder and Inorder Traversal
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        return helper(inorder,preorder,0,n-1,0,n-1);
    }
    public TreeNode helper(int[]in,int[]pre,int instart,int inend,int prestart,int preend)
    {
        if(instart>inend || prestart>preend) return null;
        int rootData=pre[prestart];
        TreeNode root=new TreeNode(rootData);
        int rootIndexInInorder=instart;
        for(int i=instart;i<=inend;i++)
        {
            if(in[i]==rootData)rootIndexInInorder=i;
        }
        int leftSubtreeSize=rootIndexInInorder-instart;
        root.left=helper(in,pre,instart,rootIndexInInorder-1,prestart+1,prestart+leftSubtreeSize);
        root.right=helper(in,pre,rootIndexInInorder+1,inend,prestart+leftSubtreeSize+1,preend);
        return root;
    }
}

// Construct Binary Tree from Inorder and Postorder Traversal
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return helper(inorder,postorder,0,n-1,0,n-1);
    }
    public TreeNode helper(int[]in,int[]post,int instart,int inend,int poststart,int postend)
    {
        if(instart>inend || poststart>postend)return null;
        int rootData=post[postend];
        TreeNode root=new TreeNode(rootData);
        int rootIndexInInorder=instart;
        for(int i=instart;i<=inend;i++)
        {
            if(in[i]==rootData)rootIndexInInorder=i;
        }
        int leftSubtreeSize=rootIndexInInorder-instart;
        root.left=helper(in,post,instart,rootIndexInInorder-1,poststart,poststart+leftSubtreeSize-1);
        root.right=helper(in,post,rootIndexInInorder+1,inend,poststart+leftSubtreeSize,postend-1);
        return root;
    }
}