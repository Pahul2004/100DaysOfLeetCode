// first completely painted row or column
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[]rowPaintCount=new int[n];
        int[]colPaintCount=new int[m];
        HashMap<Integer,int[]>valuesToPosition=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                valuesToPosition.put(mat[i][j],new int[]{i,j});
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            int value=arr[i];
            int[]position=valuesToPosition.get(value);
            int row=position[0];
            int col=position[1];
            // paint the cell
            rowPaintCount[row]++;
            colPaintCount[col]++;
            if(rowPaintCount[row]==m || colPaintCount[col]==n) return i;
        }
        return -1;
    }
}

// determine if two strings are close
class Solution {
    public boolean closeStrings(String word1, String word2) {
        // check if the lengths are different
        if(word1.length()!=word2.length())return false;
        // count the frequency of each character in each word
        int[]freq1=new int[26];
        int[]freq2=new int[26];
        for(char ch:word1.toCharArray())
        {
            freq1[ch-'a']++;
        }
        for(char ch:word2.toCharArray())
        {
            freq2[ch-'a']++;
        }
        // check if both words have same set of unique characters
        for(int i=0;i<26;i++)
        {
            if((freq1[i]==0 && freq2[i]!=0) || (freq1[i]!=0 && freq2[i]==0))return false;
        } 
        // sort the frequency arrays to compare the frequency distribution
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1,freq2);
    }
}