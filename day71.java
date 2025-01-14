// container with most water
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxArea=0; // variable to store maximum water area
        while(left<right)  
        {
            int width=right-left; // width between two lines
            int area=Math.min(height[left],height[right])*width;
            maxArea=Math.max(maxArea,area);
            // move the pointer pointing to the shorter line
            if(height[left]<height[right]) // left line is short so move the left pointer inward in hope of finding a taller line on the left
            {
                left++;
            }
            else // the right line is short or equal in height, move the right pointer inward to find a taller line on the right
            {
                right--;
            }
        }
        return maxArea;
    }
}

// Longest Subarray of 1's After Deleting One Element
class Solution {
    public int longestSubarray(int[] nums) {
        int left=0;
        int maxCount=0;
        int zeroCount=0;
        for(int right=0;right<nums.length;right++)
        {
            if(nums[right]==0)zeroCount++;
            while(zeroCount>1)
            {
                if(nums[left]==0)zeroCount--;
                left++;
            }
            maxCount=Math.max(maxCount,right-left);
        }
        return maxCount;
    }
}