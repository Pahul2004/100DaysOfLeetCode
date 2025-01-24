// find eventual safe states
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>>reversedGraph=new ArrayList<>();
        int[]outdegree=new int[n];
        for(int i=0;i<n;i++)
        {
            reversedGraph.add(new ArrayList<>());
        }
        // build the reverse graph and calculate outdegrees
        for(int i=0;i<n;i++)
        {
            for(int neighbor:graph[i])
            {
                reversedGraph.get(neighbor).add(i);
            }
            outdegree[i]=graph[i].length;
        }
        // queue for the nodes with 0 outdegree
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(outdegree[i]==0)q.add(i);
        }
        // process the nodes with 0 outdegree
        List<Integer>safeNodes=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.poll();
            safeNodes.add(node);
            for(int neighbor:reversedGraph.get(node))
            {
                outdegree[neighbor]--;
                if(outdegree[neighbor]==0) q.add(neighbor);
            }    
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}

// equal row and column pairs
class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        Map<String,Integer>rowMap=new HashMap<>();
        // convert each row to string and count its occurrences 
        for(int i=0;i<n;i++)
        {
            StringBuilder row=new StringBuilder();
            for(int j=0;j<n;j++)
            {
                row.append(grid[i][j]).append(",");
            }
            String rowStr=row.toString();
            rowMap.put(rowStr,rowMap.getOrDefault(rowStr,0)+1);
        }
        int count=0;
        // check each column against the rows
        for(int j=0;j<n;j++)
        {
            StringBuilder col=new StringBuilder();
            for(int i=0;i<n;i++)
            {
                col.append(grid[i][j]).append(",");
            }
            String colStr=col.toString();
            count+=rowMap.getOrDefault(colStr,0);
        }
        return count;
    }
}