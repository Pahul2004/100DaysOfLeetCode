// nearest exit from entrance in a maze
class Solution {
    public class Pair{
        int row;
        int col;
        int steps;
        public Pair(int row,int col,int steps)
        {
            this.row=row;
            this.col=col;
            this.steps=steps;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length;
        int m=maze[0].length;
        int srcR=entrance[0];
        int srcC=entrance[1];
        if(maze[srcR][srcC]=='+')return -1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(srcR,srcC,0));
        boolean[][]vis=new boolean[n][m];
        vis[srcR][srcC]=true;
        int[]rowDir={-1,1,0,0};
        int[]colDir={0,0,-1,1};
        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int steps=q.peek().steps;
            q.remove();
            for(int i=0;i<4;i++)
            {
                int newRow=row+rowDir[i];
                int newCol=col+colDir[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !vis[newRow][newCol] && maze[newRow][newCol]=='.')
                {
                    if(newRow==0 || newRow==n-1 || newCol==0 || newCol==m-1)return steps+1;
                    q.add(new Pair(newRow,newCol,steps+1));
                    vis[newRow][newCol]=true;
                }
            }
        }
        return -1;
    }
}

// number of islands
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
    static void helper(int ro,int co,char[][]grid,boolean[][]vis)
    {
        int n=grid.length;
        int m=grid[0].length;
        vis[ro][co]=true;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(ro,co));
        int[]rowDir={-1,1,0,0};
        int[]colDir={0,0,-1,1};
        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            for(int i=0;i<4;i++)
            {
                int newRow=row+rowDir[i];
                int newCol=col+colDir[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]=='1' && !vis[newRow][newCol])
                {
                    vis[newRow][newCol]=true;
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]vis=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && !vis[i][j])
                {
                    count++;
                    helper(i,j,grid,vis);
                }
            }
        }
        return count;
    }
}