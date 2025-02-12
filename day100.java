// longest valid parentheses
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(') st.push(i);
            else {
                st.pop();
                if(st.isEmpty()) st.push(i);
                else count=Math.max(count,i-st.peek());
            }
        }
        return count;
    }
}

// house robber
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int prev1=0;
        int prev2=0;
        for(int num:nums)
        {
            int temp=prev1;
            prev1=Math.max(prev1,prev2+num);
            prev2=temp;
        }
        return prev1;
    }
}