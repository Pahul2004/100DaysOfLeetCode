// jump game
class Solution {
    public boolean canJump(int[] nums) {
        int farthest=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>farthest)return false;
            farthest=Math.max(farthest,i+nums[i]);
            if(farthest>=nums.length-1) return true;
        }
        return true;
    }
}

// jump game 2
class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=0;
        int currentEnd=0;
        int farthest=0;
        for(int i=0;i<n-1;i++)
        {
            farthest=Math.max(farthest,i+nums[i]);
            if(i==currentEnd)
            {
                jumps+=1;
                currentEnd=farthest;
                if(currentEnd>=n-1)break;
            }        
        }
        return jumps;
    }
}