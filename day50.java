// vertical order traversal
class Solution {
    static class Pair{
        TreeNode node;
        int hd;
        int level;
        public Pair(TreeNode node,int hd,int level)
        {
            this.node=node;
            this.hd=hd;
            this.level=level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        if(root==null)return list;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0,0));
        TreeMap<Integer,List<int[]>>map=new TreeMap<>();
        while(!q.isEmpty())
        {
            TreeNode node=q.peek().node;
            int hd=q.peek().hd;
            int level=q.peek().level;
            q.remove();
            map.putIfAbsent(hd,new ArrayList<>());
            map.get(hd).add(new int[]{level,node.val});
            if(node.left!=null)q.add(new Pair(node.left,hd-1,level+1));
            if(node.right!=null)q.add(new Pair(node.right,hd+1,level+1));
        }
        for(Map.Entry<Integer,List<int[]>>entry:map.entrySet())
        {
            List<int[]>nodes=entry.getValue();
            nodes.sort((a,b)->(a[0]==b[0])?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
            List<Integer>vertical=new ArrayList<>();
            for(int[]node:nodes)
            {
                vertical.add(node[1]);
            }
            list.add(vertical);
        }
        return list;
    }
}

// cousins in binary tree
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            boolean xFound=false;
            boolean yFound=false;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode current=q.poll();
                if(current.left!=null && current.right!=null)
                {
                    if(current.left.val==x && current.right.val==y || current.left.val==y && current.right.val==x)
                    {
                        return false;
                    }
                }
                if(current.left!=null)
                {
                    if(current.left.val==x)xFound=true;
                    if(current.left.val==y)yFound=true;
                    q.add(current.left);
                }
                if(current.right!=null)
                {
                    if(current.right.val==x)xFound=true;
                    if(current.right.val==y)yFound=true;
                    q.add(current.right);
                }
            }
            if(xFound && yFound)return true;
            if(xFound || yFound)return false;
        }
        return false;
    }
}