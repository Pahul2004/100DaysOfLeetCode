// shortest path in binary matrix
class Solution {
    public class Pair{
        int row;
        int col;
        int pathLength;
        public Pair(int row,int col, int pathLength)
        {
            this.row=row;
            this.col=col;
            this.pathLength=pathLength;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        // 0 -> allowed
        // 1 -> blocked cell
        // if the starting or the ending cell is blocked return -1
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0)return -1;
        int[][]directions={
            {-1,-1},{-1,0},{-1,1},
            {0,-1},        {0,1},
            {1,-1},{1,0},{1,1}
        };
        Queue<Pair>q=new LinkedList<>(); 
        q.add(new Pair(0,0,1)); // row,col,path length
        grid[0][0]=1; // mark as visited by changing 0 to 1
        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int pathLength=q.peek().pathLength;
            q.remove();

            if(row==n-1 && col==n-1)return pathLength;
            // explore all 8 directions
            for(int[]dir:directions)
            {
                int newRow=row+dir[0];
                int newCol=col+dir[1]; 
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==0)
                {
                    q.add(new Pair(newRow,newCol,pathLength+1));
                    grid[newRow][newCol]=1;
                }
            }
        }
        return -1;
    }
}

// pacific atlantic water flow
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
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        boolean[][]atlantic=new boolean[n][m];
        boolean[][]pacific=new boolean[n][m];
        Queue<Pair>atlanticQueue=new LinkedList<>();
        Queue<Pair>pacificQueue=new LinkedList<>();
        List<List<Integer>>result=new ArrayList<>();
        // initialize queues with border cells
        for(int i=0;i<n;i++)
        {
            pacificQueue.add(new Pair(i,0)); // top boundary
            atlanticQueue.add(new Pair(i,m-1)); // bottom boundary
            pacific[i][0]=true;
            atlantic[i][m-1]=true;
        }
        for(int j=0;j<m;j++)
        {
            pacificQueue.add(new Pair(0,j)); // left boundary
            atlanticQueue.add(new Pair(n-1,j)); // right boundary
            pacific[0][j]=true;
            atlantic[n-1][j]=true;
        }
        helper(heights,pacific,pacificQueue);
        helper(heights,atlantic,atlanticQueue);

        // collect the cells that can flow in both the oceans
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    public void helper(int[][]heights,boolean[][]ocean,Queue<Pair>queue)
    {
        int n=heights.length;
        int m=heights[0].length;
        int[]rowDir={-1,1,0,0};
        int[]colDir={0,0,-1,1};
        while(!queue.isEmpty())
        {
            Pair cell=queue.poll();
            int row=cell.row;
            int col=cell.col;
            for(int i=0;i<4;i++)
            {
                int newRow=row+rowDir[i];
                int newCol=col+colDir[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !ocean[newRow][newCol] && heights[newRow][newCol]>=heights[row][col])
                {
                    ocean[newRow][newCol]=true;
                    queue.add(new Pair(newRow,newCol));
                }
            }
        }
    }
}
