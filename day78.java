// maximum twin sum of a linkedlist
class Solution {
    public int pairSum(ListNode head) {
        List<Integer>list=new ArrayList<>();
        while(head!=null)
        {
            list.add(head.val);
            head=head.next;
        }
        int n=list.size();
        int maxSum=0;
        for(int i=0;i<=n/2;i++)
        {
            int pairSum=list.get(i)+list.get(n-i-1);
            maxSum=Math.max(maxSum,pairSum);
        }
        return maxSum;
    }
}

// keys and rooms
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[]vis=new boolean[n];
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty())
        {
            int currentRoom=q.poll();
            for(int key:rooms.get(currentRoom))
            {
                if(!vis[key])
                {
                    vis[key]=true;
                    q.add(key);
                }
            }
        }
        for(boolean isVisited:vis)
        {
            if(!isVisited)return false;
        }
        return true;
    }
}