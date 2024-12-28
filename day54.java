// delete node in a bst
class Solution {
    static int maxVal(TreeNode root)
    {
        TreeNode temp=root;
        if(temp==null)return -1;
        while(temp.right!=null)
        {
            temp=temp.right;
        }
        return temp.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        // base case 
        if(root==null)return null;
        
        // target found
        if(root.val==key)
        {
            // case 1(leaf node)
            if(root.left==null && root.right==null)
            {
                return null;
            }
            // case 2(left node present)
            if(root.left!=null && root.right==null)
            {
                TreeNode child=root.left;
                return child;
            }
            // case 3(right child present)
            if(root.left==null && root.right!=null)
            {
                TreeNode child=root.right;
                return child;
            }
            // case 4(both children present)
            if(root.left!=null && root.right!=null)
            {
                // find inorder predecessor in left subtree
                int inorderpre=maxVal(root.left);
                // replace the root.val with inorderpre
                root.val=inorderpre;
                // delete inorderpre from left subtree
                root.left=deleteNode(root.left,inorderpre);
                return root;
            }
        }
        else if(root.val>key)
        {
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key)
        {
            root.right=deleteNode(root.right,key);
        }
        return root;
    }
}

// range sum of bst
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int sum=0;
        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if(curr.val>=low && curr.val<high)sum+=curr.val;
            if(curr.left!=null)q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
        }
        return sum;
    }
}