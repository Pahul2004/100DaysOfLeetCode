// maximum number of fish in a grid
class Solution {
    static class Pair{
        int row;
        int col;
        public Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]vis=new boolean[n][m];
        int maxSum=0;
        int[]rowDir={-1,1,0,0};
        int[]colDir={0,0,-1,1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]>0 && !vis[i][j])
                {
                    int sum=0;
                    Queue<Pair>q=new LinkedList<>();
                    q.add(new Pair(i,j));
                    vis[i][j]=true;
                    while(!q.isEmpty())
                    {
                        int row=q.peek().row;
                        int col=q.peek().col;
                        q.remove();
                        sum+=grid[row][col];
                        for(int d=0;d<4;d++)
                        {
                            int newRow=row+rowDir[d];
                            int newCol=col+colDir[d];
                            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !vis[newRow][newCol] && grid[newRow][newCol]>0)
                            {
                                q.add(new Pair(newRow,newCol));
                                vis[newRow][newCol]=true;
                            }
                        }
                    }
                    maxSum=Math.max(maxSum,sum);
                }
            }
        }
        return maxSum;
    }
}

// path sum 2
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>currentPath=new ArrayList<>();
        dfs(root,targetSum,currentPath,list);
        return list;
    }
    public void dfs(TreeNode root,int targetSum,List<Integer>currentPath,List<List<Integer>>list)
    {
        if(root==null)return ;
        // add current node's value to the path
        currentPath.add(root.val);
        // check if the current node is a leaf an the path sum equals target sum
        if(root.left==null && root.right==null && root.val==targetSum)
        {
            list.add(new ArrayList<>(currentPath));
        }
        else
        {
            dfs(root.left,targetSum-root.val,currentPath,list);
            dfs(root.right,targetSum-root.val,currentPath,list);
        }
        currentPath.remove(currentPath.size()-1);
    }
}