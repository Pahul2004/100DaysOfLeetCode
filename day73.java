// leaf-similar trees
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        getLeaves(root1,list1);
        getLeaves(root2,list2);
        return list1.equals(list2);
    }
    static void getLeaves(TreeNode root,List<Integer>list)
    {
        if(root==null)return;
        if(root.left==null && root.right==null)list.add(root.val);
        getLeaves(root.left,list);
        getLeaves(root.right,list);
    }
}

// longest zigzag path in a binary tree
class Solution {
    private int maxZigzagLength=0;
    public int longestZigZag(TreeNode root) {
        if(root==null)return 0;
        dfs(root,true,0); // start with right direction
        dfs(root,false,0); // start with left direction
        return maxZigzagLength;
    }
    public void dfs(TreeNode root,boolean isRight,int length)
    {
        if(root==null)return ;
        // update the maximum zigzag length found so far
        maxZigzagLength=Math.max(maxZigzagLength,length);
        // if moving to the right,explore the right subchild and reset the direction to left
        if(isRight)
        {
            dfs(root.right,false,length+1); // move right and switch to left
            dfs(root.left,true,1); // start a new zigzag path from left child
        }
        else
        {
            dfs(root.left,true,length+1); // move left and switch to right
            dfs(root.right,false,1); // start a new zigzag path from right child
        }
    }
}