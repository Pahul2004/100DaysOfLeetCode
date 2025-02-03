// flood fill
class Solution {
    static class Pair{
        int row,col;
        public Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int originalColor=image[sr][sc];
        if(originalColor==color)return image;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        int[]rowDir={-1,1,0,0};
        int[]colDir={0,0,-1,1};
        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            image[row][col]=color;
            for(int i=0;i<4;i++)
            {
                int newRow=row+rowDir[i];
                int newCol=col+colDir[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && image[newRow][newCol]==originalColor)
                {
                    q.add(new Pair(newRow,newCol));
                }
            }
        }
        return image;
    }
}

// 01 matrix
class Solution {
    static class Pair{
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
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][]vis=new int[n][m];
        int[][]dist=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    vis[i][j]=1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int[]rowDir={-1,1,0,0};
        int[]colDir={0,0,-1,1};
        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int steps=q.peek().steps;
            q.remove();
            dist[row][col]=steps;
            for(int i=0;i<4;i++)
            {
                int newRow=row+rowDir[i];
                int newCol=col+colDir[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol]==0)
                {
                    vis[newRow][newCol]=1;
                    q.add(new Pair(newRow,newCol,steps+1));
                }
            }
        }        
        return dist;
    }
}