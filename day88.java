// combination sum 3
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>list=new ArrayList<>();
        backtrack(1,k,n,new ArrayList<>(),list);
        return list;
    }
    static void backtrack(int start,int k,int target,List<Integer>path,List<List<Integer>>list)
    {
        if(path.size()==k && target==0)
        {
            list.add(new ArrayList<>(path));
            return ;
        }
        for(int i=start;i<=9;i++)
        {
            if(target<i)break;
            path.add(i);
            backtrack(i+1,k,target-i,path,list);
            path.remove(path.size()-1);
        }
    }
}

// nth tribonacci number
class Solution {
    public int tribonacci(int n) {
        if(n==0)return 0;
        if(n==1 || n==2)return 1;
        int a=0;
        int b=1;
        int c=1;
        for(int i=3;i<=n;i++)
        {
            int sum=a+b+c;
            a=b;
            b=c;
            c=sum;
        }
        return c;
    }
}