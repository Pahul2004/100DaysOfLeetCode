// average of levels in a binary tree
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>list=new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            double sum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.peek();
                q.remove();
                sum+=curr.val;
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
            list.add(sum/size);
        }
        return list;
    }
}

// group anagrams
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(String word:strs)
        {
            char[]chars=word.toCharArray();
            Arrays.sort(chars); // sort characters
            String sortedWord=new String(chars); // convert back to string
            // map.computeIfAbsent(sortedWord,k->new ArrayList<>()).add(word);
            if(!map.containsKey(sortedWord))
            {
                map.put(sortedWord,new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}