// perfect squares
class Solution {
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j*j<=i;j++)
            {
                dp[i]=Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
}

// defuse the bomb
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int[]result=new int[n];
        if(k==0)return result;
        int sum=0;
        int start=(k>0)?1:n+k;
        int end=(k>0)?k:n-1;
        for(int i=start;i<=end;i++)
        {
            sum+=code[i%n];
        }
        for(int i=0;i<n;i++)
        {
            result[i]=sum;
            sum-=code[start%n];
            start++;
            end++;
            sum+=code[end%n];
        }
        return result;
    }
}