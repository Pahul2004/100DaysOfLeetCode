// dota2 senate
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer>radiant=new LinkedList<>();
        Queue<Integer>dire=new LinkedList<>();

        // populate queues with the initial positions of R and D
        for(int i=0;i<senate.length();i++)
        {
            if(senate.charAt(i)=='R') radiant.add(i);
            else dire.add(i);
        }
        int n=senate.length();
        // simulate the voting process
        while(!radiant.isEmpty() && !dire.isEmpty())
        {
            int radiantIndex=radiant.poll();
            int direIndex=dire.poll();

            // the voter with smaller index bans the other
            if(radiantIndex<direIndex) radiant.add(radiantIndex+n);
            else dire.add(direIndex+n);
        }
        return radiant.isEmpty()?"Dire":"Radiant";
    }
}

// number of recent calls 
class RecentCounter {
    private Queue<Integer>requests;
    public RecentCounter() {
        requests=new LinkedList<>();
    }
    
    public int ping(int t) {
        // add the new request to the queue
        requests.add(t);

        // remove the requests that are outside the 3000ms window
        while(!requests.isEmpty() && requests.peek()<t-3000)
        {
            requests.poll();
        }
        // return the number of requests within the window
        return requests.size();
    }
}