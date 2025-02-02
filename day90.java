// rotting oranges
class Solution {
    static class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time)
        {
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]vis=new int[n][m];
        int countFresh=0;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)countFresh++;
                else if(grid[i][j]==2 && vis[i][j]==0)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
            }
        }
        int count=0;
        int time=0;
        int[]rowDir={-1,1,0,0};
        int[]colDir={0,0,-1,1};
        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int t=q.peek().time;
            time=Math.max(time,t);
            q.remove();

            for(int i=0;i<4;i++)
            {
                int newRow=row+rowDir[i];
                int newCol=col+colDir[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]==1 && vis[newRow][newCol]==0)
                {
                    count++;
                    q.add(new Pair(newRow,newCol,t+1));
                    vis[newRow][newCol]=2;
                }
            }
        }
        if(count!=countFresh)return -1;
        return time;
    }
}

// number of provinces
class Solution {
    static void helper(List<List<Integer>>adj,boolean[]vis,int node)
    {
        vis[node]=true;
        for(int neighbour:adj.get(node))
        {
            if(!vis[neighbour])
            {
                helper(adj,vis,neighbour);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected[0].length;i++)
        {
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count=0;
        boolean[]vis=new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++)
        {
            if(!vis[i])
            {
                count++;
                helper(adj,vis,i);
            }
        }
        return count;
    }
}