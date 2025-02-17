// maximum sum of distinct subarrays with length k
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        if(k>n)return 0;
        long maxSum=0,currSum=0;
        Set<Integer>numSet=new HashSet<>();
        int left=0;
        for(int right=0;right<n;right++)
        {
            while(numSet.contains(nums[right]) || right-left+1>k)
            {
                numSet.remove(nums[left]);
                currSum-=nums[left];
                left++;
            }
            numSet.add(nums[right]);
            currSum+=nums[right];
            if(right-left+1==k)
            {
                maxSum=Math.max(maxSum,currSum);
            }
        }
        return maxSum;
    }
}

// top k frequent elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer>minHeap=new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(int key:map.keySet())
        {
            minHeap.add(key);
            if(minHeap.size()>k)minHeap.poll();
        }
        int[]result=new int[k];
        for(int i=0;i<k;i++)
        {
            result[i]=minHeap.poll();
        }
        return result;
    }
}