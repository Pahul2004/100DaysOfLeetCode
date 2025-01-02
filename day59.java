// sum of nodes with even valued grandparents
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root,null,null);
    }
    public int helper(TreeNode root,TreeNode parent,TreeNode grandparent)
    {
        if(root==null)return 0;
        int sum=0;
        if(grandparent!=null && grandparent.val%2==0)
        {
            sum=sum+root.val;
        }
        sum+=helper(root.left,root,parent);
        sum+=helper(root.right,root,parent);
        return sum;
    }
}

// all elements in two binary search trees
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        inorder(root1,list1);
        inorder(root2,list2);
        return merge(list1,list2);
    }
    public void inorder(TreeNode root,List<Integer>list)
    {
        if(root==null)return ;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public List<Integer>merge(List<Integer>list1,List<Integer>list2)
    {
        List<Integer>merged=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size())
        {
            if(list1.get(i)<list2.get(j))merged.add(list1.get(i++));
            else merged.add(list2.get(j++));
        }
        while(i<list1.size())merged.add(list1.get(i++));
        while(j<list2.size())merged.add(list2.get(j++));
        return merged;
    }
}