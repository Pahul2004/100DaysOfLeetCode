// max consecutive ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
        for(int num:nums)
        {
            if(num==1)count++;
            else count=0;
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}

// max consecutive ones 3
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int zeroCount=0;
        int maxCount=0;
        for(int right=0;right<nums.length;right++)
        {
            // if the current number is 0 , increment the zeroCount;
            if(nums[right]==0)zeroCount++;
            // if the zeroCount exceeds k , shrink the window from left 
            while(zeroCount>k)
            {
                if(nums[left]==0)zeroCount--;
                left++;
            }
            // update the maximum length of the subarray
            maxCount=Math.max(maxCount,right-left+1);
        }
        return maxCount;
    }
}