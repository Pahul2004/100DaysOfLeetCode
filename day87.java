// unique paths
class Solution {
    public int uniquePaths(int m, int n) {
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[j]+=dp[j-1];
            }
        }
        return dp[n-1];
    }
}

// successful pairs of spells and potions
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=spells.length;
        int m=potions.length;
        int[]result=new int[n];
        for(int i=0;i<n;i++)
        {
            int spell=spells[i];
            int left=0;
            int right=m-1;
            int index=m;
            // binary search for the smallest valid potion
            while(left<=right)
            {
                int mid=left+(right-left)/2;
                if((long)spell*potions[mid]>=success)
                {
                    index=mid;
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
            result[i]=m-index;
        }
        return result;
    }
}