// count servers taht communicate
class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[]rowCount=new int[n];
        int[]colCount=new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && (rowCount[i]>1 || colCount[j]>1))
                {
                    count++;
                }
            }
        }
        return count;
    }
}

// asteroid collision
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // used to keep the track of asteroids that are still moving
        Stack<Integer>st=new Stack<>();
        for(int asteroid:asteroids)
        {
            boolean exploded=false; // flag to track if the current asteroid explodes
            // check for collisions : current asteroid is moving left(<0)
            // top of the stack is moving right(>0)
            while(!st.isEmpty() && asteroid<0 && st.peek()>0)
            {
                // compare the size of 2 asteroids
                if(st.peek()<Math.abs(asteroid))
                {
                    // if stack asteroid is smaller, it explodes(pop from stack)
                    st.pop();
                }
                else if(st.peek()==Math.abs(asteroid))
                {
                    // both asteroids are of same size , both explode
                    st.pop();
                    exploded=true; // current asteroid also explodes
                    break;
                }
                else 
                {
                    // stack asteroid is larger , current asteroid explodes
                    exploded=true;
                    break;
                }
            }
            // if the current asteroid does'nt explode , add it to the stack
            if(!exploded)
            {
                st.push(asteroid);
            }
        }
        int[]result=new int[st.size()];
        for(int i=result.length-1;i>=0;i--)
        {
            result[i]=st.pop();
        }
        return result;
    }
}