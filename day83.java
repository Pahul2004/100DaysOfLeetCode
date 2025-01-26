// Reorder Routes to Make All Paths Lead to the City Zero
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>>graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[]connection:connections)
        {
            graph.get(connection[0]).add(new int[]{connection[1],1}); // original direction
            graph.get(connection[1]).add(new int[]{connection[0],0}); // reverse direction
        }
        boolean[]vis=new boolean[n];
        return dfs(0,graph,vis);
    }
    public int dfs(int current,List<List<int[]>>graph,boolean[]vis)
    {
        vis[current]=true;
        int changes=0;
        for(int[]neighbor:graph.get(current))
        {
            int nextCity=neighbor[0];
            int direction=neighbor[1];
            if(!vis[nextCity])
            {
                changes+=direction; // count if it is an original direction
                changes+=dfs(nextCity,graph,vis); // recursively visit neighbors
            }
        }
        return changes;
    }
}

// smallest number in infinite set
class SmallestInfiniteSet {
    private TreeSet<Integer>set;
    private int current;
    public SmallestInfiniteSet() {
        set=new TreeSet<>();
        current=1; // smallest positive integer
    }
    
    public int popSmallest() {
        if(!set.isEmpty()) return set.pollFirst(); // return the smallest element after removing it
        else return current++; // return the current smallest element and then increment it
    }
    
    public void addBack(int num) {
        // add the number only if it is smaller than the current element and does'nt already exist in the set
        if(num<current && !set.contains(num))
        {
            set.add(num);
        }
    }
}
