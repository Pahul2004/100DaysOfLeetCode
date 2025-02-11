// word break
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String>wordSet=new HashSet<>(wordDict); // convert list to set for quick lookup
        int n=s.length();
        boolean[]dp=new boolean[n+1];
        dp[0]=true; // empty string is always breakable
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] && wordSet.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break; // no need to check further
                }
            }
        }
        return dp[n];
    }
}

// copy list with random pointer
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        // Step 1: Create new nodes interleaved with original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        // Step 2: Assign random pointers for the new nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Step 3: Separate the original list and the copied list
        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;
        
        while (curr != null) {
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        
        return dummyHead.next;
    }
}