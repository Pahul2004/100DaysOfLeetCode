// clear digits
class Solution {
    public String clearDigits(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                while(!st.isEmpty() && Character.isDigit(st.peek())) st.pop();
                if(!st.isEmpty()) st.pop();
            }
            else st.push(ch);
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}

// coin change
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max=amount+1;
        int[]dp=new int[amount+1];
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int coin:coins)
        {
            for(int i=coin;i<=amount;i++)
            {
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==max?-1:dp[amount];
    }
}