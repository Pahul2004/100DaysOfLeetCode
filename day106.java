// search a 2d matrix 2
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int row=0,col=cols-1; // start from top right corner
        while(row<rows && col>=0)
        {
            if(matrix[row][col]==target)return true;
            else if(matrix[row][col]>target)col--; // move left(eliminate current column)
            else row++; // move down(eliminate current row)
        }
        return false;
    }
}

// longest consecutive sequence
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        HashSet<Integer>set=new HashSet<>();
        int longestStreak=0;
        for(int num:nums)set.add(num);
        for(int num:set)
        {
            if(!set.contains(num-1))
            {
                int currentNum=num;
                int currentStreak=1;
                while(set.contains(currentNum+1))
                {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}