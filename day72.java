// can place flowers
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for(int i=0;i<flowerbed.length;i++)
        {
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0))
            {
                flowerbed[i]=1; // plant a flower here
                count++;
            }
            if(count>=n)return true;
        }
        return false;
    }
}

// find pivot index
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum=0;
        int leftSum=0;
        for(int num:nums)
        {
            totalSum+=num;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(leftSum==totalSum-leftSum-nums[i]) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}