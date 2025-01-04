// rotate image
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        
        // transpose the matrix
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        // reverse each row of the matrix
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
}

// spiral matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>list=new ArrayList<>();
        if(matrix==null || matrix.length==0)return list;
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0,bottom=n-1;
        int left=0,right=m-1;
        while(top<=bottom && left<=right)
        {
            // move left to right along top boundary
            for(int i=left;i<=right;i++)
            {
                list.add(matrix[top][i]);
            }
            top++; // move top boundary downwards

            // move top to bottom along right boundary
            for(int i=top;i<=bottom;i++)
            {
                list.add(matrix[i][right]);
            }
            right--; // move right boundary inwards(left)

            // move right to left along bottom boundary
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    list.add(matrix[bottom][i]);
                }
            }
            bottom--; // move bottom boundary upwards

            // move bottom to top along left boundary
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    list.add(matrix[i][left]);
                }
            }
            left++; // move left boundary inwards(right)
        }
        return list;
    }
}