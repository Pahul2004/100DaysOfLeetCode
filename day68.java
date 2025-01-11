// letter combinations of a phone number
class Solution {
    private static final String[]KeyPad={
        "" ,// 0
        "" ,// 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5 
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz", // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String>list=new ArrayList<>();
        if(digits==null || digits.isEmpty())return list;
        backtrack(list,new StringBuilder(),digits,0);
        return list;
    }
    private void backtrack(List<String>list,StringBuilder current,String digits,int index)
    {
        if(index==digits.length())
        {
            list.add(current.toString());
            return ;
        }
        String letters=KeyPad[digits.charAt(index)-'0'];
        for(char letter:letters.toCharArray())
        {
            current.append(letter);
            backtrack(list,current,digits,index+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}

// maximum average subarray 1
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum=0,currentSum=0;
        for(int i=0;i<k;i++)
        {
            currentSum+=nums[i];
        }
        maxSum=currentSum;
        for(int i=k;i<nums.length;i++)
        {
            currentSum+=nums[i]-nums[i-k];
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum/k;
    }
}