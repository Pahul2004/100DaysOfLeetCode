// koko eating bananas
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=0;
        for(int pile:piles)
        {
            right=Math.max(right,pile);
        }
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(canFinish(piles,h,mid))
            {
                right=mid; // try smaller speed
            }
            else {
                left=mid+1; // increase the speed
            }
        }
        return left;
    }
    public boolean canFinish(int[]piles,int h,int k)
    {
        int hours=0;
        for(int pile:piles)
        {
            hours+=(pile+k-1)/k; // calculate the hours required for the pile
        }
        return hours<=h;
    }
}

// min cost climbing stairs
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n==1)return cost[0];
        if(n==2)return Math.min(cost[0],cost[1]);
        int prev=cost[0];
        int prev2=cost[1];
        // start from the 3rd step and calculate the minimum cost to reach each step
        for(int i=2;i<n;i++)
        {
            int current=Math.min(prev,prev2)+cost[i];
            prev=prev2;
            prev2=current;
        }
        return Math.min(prev,prev2);
    }
}
