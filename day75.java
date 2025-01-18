// find highest altitude
class Solution {
    public int largestAltitude(int[] gain) {
        int highestAltitude=0;
        int currentAltitude=0;
        for(int g:gain)
        {
            currentAltitude+=g; // update the current altitude
            highestAltitude=Math.max(highestAltitude,currentAltitude);
        }
        return highestAltitude;
    }
}

// greatest common divisor of strings
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //step 1: check if str1 and str2 can form a common divisor 
        if(!(str1 + str2).equals(str2 + str1)) {
            return ""; // no common divisor exists
        } 
        //step 2: Find gcd of the lengths of str1 and str2
        int gcdLength = findGCD(str1.length(),str2.length());
        //step 3: Return the substring of str1 from beginning upto GCD length
        return str1.substring(0,gcdLength);
    }
    private int findGCD(int a, int b){
        //Keep calculating the remainder until b becomes 0
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; // when b becomes 0, a is the GCD
    }
}