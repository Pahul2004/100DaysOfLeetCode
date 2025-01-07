// remove stars from a string
class Solution {
    public String removeStars(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(st.isEmpty()) st.push(ch);
            else
            {
                if(ch=='*' && !st.isEmpty()) st.pop();
                else st.push(ch);
            }
        }
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}

// longest palindromic subsequence
class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        int n=s.length();
        int m=rev.length();
        int[][]dp=new int[n+1][m+1];
        for(int[]row:dp)
        {
            Arrays.fill(row,-1);
        }
        return helper(s,rev,n,m,dp);
    }
    public int helper(String s,String rev,int n,int m,int[][]dp)
    {
        if(n==0 || m==0)return 0; // if the length of any string is 0 then return 0 
        if(dp[n][m]!=-1)return dp[n][m]; // return the precompute result if available
        if(s.charAt(n-1)==rev.charAt(m-1))
        {
            dp[n][m]=1+helper(s,rev,n-1,m-1,dp); // increment the length by including the current characters
        }
        else // characters dont match
        {
            // fin the maximum subsequence by either excluding current char of first or the second string
            dp[n][m]=Math.max(helper(s,rev,n-1,m,dp),helper(s,rev,n,m-1,dp));
        }
        return dp[n][m];
    }
}