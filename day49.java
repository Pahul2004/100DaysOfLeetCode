// invert binary tree
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

// zigzag traversal of binary tree
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>zigZag=new ArrayList<>(); // store final answer in this
        if(root==null)return zigZag;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        boolean LTR=true; // left to right (direction check for each level)
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer>currentLevel=new ArrayList<>(); // store current level
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(LTR)currentLevel.add(node.val); // if left to right jana hai to normally add krdo current level ki list mein
                else currentLevel.add(0,node.val); // if right to left jaare hai to reverse manner mein add krdo current level ki list mein
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            LTR=!LTR; // reverse direction after every level
            zigZag.add(currentLevel); // add current level after all nodes at that level have been processed
        }
        return zigZag;
    }
}