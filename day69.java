// move zeroes
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int j=0;
        for(int num:nums)
        {
            if(num!=0)
            {
                nums[j++]=num;
            }
        }
        while(j<n)
        {
            nums[j++]=0;
        }
    }
}

// Maximum Number of Vowels in a Substring of Given Length
class Solution {
    private static boolean isVowel(char ch)
    {
        return "aeiouAEIOU".indexOf(ch)!=-1;
    }
    public int maxVowels(String s, int k) {
        int maxVowels=0,currentVowels=0;
        for(int i=0;i<s.length();i++)
        {
            if(isVowel(s.charAt(i)))
            {
                currentVowels++;
            }
            if(i>=k && isVowel(s.charAt(i-k)))
            {
                currentVowels--;
            }
            maxVowels=Math.max(maxVowels,currentVowels);
        }
        return maxVowels;
    }
}