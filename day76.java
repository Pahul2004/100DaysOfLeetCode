// kids with the greatest number of candies
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean>result=new ArrayList<>();
        int maxCandies=0;
        // count the maximum number of candies any kid has
        for(int candy:candies)
        {
            maxCandies=Math.max(maxCandies,candy);
        }
        // check if each kid can have greatest number of candies
        for(int candy:candies)
        {
            result.add(candy+extraCandies>=maxCandies);
        }
        return result;
    }
}

// increasing triplet subsequence
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int num:nums)
        {
            if(num<=first)
            {
                // update the smallest number
                first=num;
            }
            else if(num<=second)
            {
                // update the second smallest number
                second=num;
            }
            else return true; // found a number greater than both, indicating an increasing triplet
        }
        return false; // no triplet found
    }
}