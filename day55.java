// Construct Binary Search Tree from Preorder Traversal
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        if(n==0)return null;
        TreeNode root=null;
        root=new TreeNode(preorder[0]);
        for(int i=1;i<n;i++)
        {
            root=insert(root,preorder[i]);
        }
        return root;
    }
    static TreeNode insert(TreeNode root,int data)
    {
        if(root==null)return new TreeNode(data);
        if(data>root.val)root.right=insert(root.right,data);
        if(data<root.val)root.left=insert(root.left,data);
        return root;
    }
}

// Kth Smallest Element in a BST
class Solution {
    static List<Integer>inorder(TreeNode root,List<Integer>list)
    {
        if(root==null)return list;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return list;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer>list=new ArrayList<>();
        list=inorder(root,list);
        if(k<=0 || k>list.size())return -1;
        return list.get(k-1);
    }
}