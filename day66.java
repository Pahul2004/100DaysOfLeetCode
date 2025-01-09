// max number of k-sum pairs
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int operations=0;
        for(int num:nums)
        {
            int complement=k-num;
            if(map.getOrDefault(complement,0)>0)
            {
                operations++;
                map.put(complement,map.get(complement)-1);
            }
            else
            {
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        return operations;
    }
}

// string compression
class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int index=0;
        int i=0;
        while(i<n)
        {
            char currentChar=chars[i];
            int count=0;
            while(i<n && currentChar==chars[i])
            {
                count++;
                i++;
            }
            chars[index++]=currentChar;
            if(count>1)
            {
                for(char ch:Integer.toString(count).toCharArray())
                {
                    chars[index++]=ch;
                }
            }
        }
        return index;
    }
}