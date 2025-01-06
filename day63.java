// Uncommon Words from Two Sentences
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[]words=(s1+" "+s2).split(" ");
        HashMap<String,Integer>map=new HashMap<>();
        for(String word:words)
        {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String>list=new ArrayList<>();
        for(Map.Entry<String,Integer>entry:map.entrySet())
        {
            int freq=entry.getValue();
            if(freq==1)list.add(entry.getKey());
        }
        return list.toArray(new String[0]);
    }
}

// Check if One String Swap Can Make Strings Equal
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2))return true;
        int n=s1.length();
        int m=s2.length();
        if(n!=m)return false;
        int diffCount=0;
        int[]diffIndices=new int[2];
        for(int i=0;i<n;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                if(diffCount==2)return false;
                diffIndices[diffCount]=i;
                diffCount++;
            }
        }
        return diffCount==2 &&
               s1.charAt(diffIndices[0])==s2.charAt(diffIndices[1]) &&
               s1.charAt(diffIndices[1])==s2.charAt(diffIndices[0]);
    }
}