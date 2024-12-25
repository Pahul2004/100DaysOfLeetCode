// find largest in each tree row
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>largest=new ArrayList<>();
        if(root==null)return largest;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int maxVal=Integer.MIN_VALUE;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                maxVal=Math.max(maxVal,node.val);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            largest.add(maxVal);
        }
        return largest;
    }
}

// search in a bst
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)return null;
        while(root!=null)
        {
            if(root.val==val)return root;
            root=(val<root.val)?root.left:root.right;
        }
        return null;
    }
}