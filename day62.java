// capitalize the title
class Solution {
    public String capitalizeTitle(String title) {
        String[]words=title.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(String word:words)
        {
            if(word.length()<=2)sb.append(word.toLowerCase()).append(" ");
           else
           {
             sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
           }
        }
        return sb.toString().trim();
    }
}

// backspace string compare
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return helper(s).equals(helper(t));
    }
    public String helper(String str)
    {
        StringBuilder sb=new StringBuilder();
        for(char ch:str.toCharArray())
        {
            if(ch=='#')
            {
                if(sb.length()>0)
                {
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}