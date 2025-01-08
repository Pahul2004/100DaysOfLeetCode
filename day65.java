// longest palindrome
class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }   
        int length=0;
        boolean hasOdd=false;
        for(int count:map.values())
        {
            length+=(count/2)*2;
            if(count%2==1)hasOdd=true;
        }
        if(hasOdd)return length+=1;
        return length;
    }
}

// maximum level sum of binary tree
class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root==null)return 0;
        int maxSum=root.val;
        int level=1;
        int ansLevel=level;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int sum=0;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
            if(sum>maxSum)
            {
                maxSum=sum;
                ansLevel=level;
            }
            level++;
        }
        return ansLevel;
    }
}