// surrounded regions
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
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        Queue<Pair>q=new LinkedList<>();
        // add all boundary O's to the queue
        for(int i=0;i<n;i++)
        {
            // first column
            if(board[i][0]=='O')q.add(new Pair(i,0));
            // last column
            if(board[i][m-1]=='O')q.add(new Pair(i,m-1));
        }
        for(int j=0;j<m;j++)
        {
            // first row
            if(board[0][j]=='O')q.add(new Pair(0,j));
            // last row
            if(board[n-1][j]=='O')q.add(new Pair(n-1,j));
        }
        int[]rowDir={-1,1,0,0};
        int[]colDir={0,0,-1,1};
        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            board[row][col]='S';
            for(int i=0;i<4;i++)
            {
                int newRow=row+rowDir[i];
                int newCol=col+colDir[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && board[newRow][newCol]=='O')
                {
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='S')board[i][j]='O';
                else if(board[i][j]=='O')board[i][j]='X';
            }
        }
    }
}

// number of enclaves
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
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]vis=new boolean[n][m];
        Queue<Pair>q=new LinkedList<>();
        // boundary vle check krlo
        for(int i=0;i<n;i++)
        {
            // first column
            if(grid[i][0]==1)
            {
                q.add(new Pair(i,0));
                vis[i][0]=true;
            }
            // last column
            if(grid[i][m-1]==1)
            {
                q.add(new Pair(i,m-1));
                vis[i][m-1]=true;
            }
        }
        for(int j=0;j<m;j++)
        {
            // first row
            if(grid[0][j]==1)
            {
                q.add(new Pair(0,j));
                vis[0][j]=true;
            }
            // last row
            if(grid[n-1][j]==1)
            {
                q.add(new Pair(n-1,j));
                vis[n-1][j]=true;
            }
        }
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
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]==1 && !vis[newRow][newCol])
                {
                    vis[newRow][newCol]=true;
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && !vis[i][j])
                {
                    count++;
                }
            }
        }
        return count;
    }
}