// kth largest element in an array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        for(int num:nums)
        {
            minHeap.add(num);
            if(minHeap.size()>k)minHeap.poll();
        }
        return minHeap.peek();
    }
}

// map of highest peak
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
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        int[][]height=new int[n][m];
        for(int[]row:height)
        {
            Arrays.fill(row,-1);
        }
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(isWater[i][j]==1)
                {
                    height[i][j]=0;
                    q.add(new Pair(i,j));
                }
            }
        }
        int[]rowDir={-1,1,0,0};
        int[]colDir={0,0,-1,1};
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            for(int i=0;i<4;i++)
            {
                int newRow=row+rowDir[i];
                int newCol=col+colDir[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && height[newRow][newCol]==-1)
                {
                    q.add(new Pair(newRow,newCol));
                    height[newRow][newCol]=height[row][col]+1;
                }
            }
        }
        return height;
    }
}