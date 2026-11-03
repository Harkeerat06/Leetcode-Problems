class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD= 1_000_000_007;
        List<List<int[]>> list= new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(new ArrayList<>());

        for(int arr[]: roads)
        {
            int u= arr[0];
            int v= arr[1];
            int t= arr[2];

            list.get(u).add(new int[]{v,t});
            list.get(v).add(new int[]{u,t});
        }

        int ways[]= new int[n];
        long dist[]= new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]= 0;
        ways[0]= 1;

        PriorityQueue<long[]> pq= new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty())
        {
            long arr[]= pq.poll();
            int node= (int)arr[0];
            long d= arr[1];

            if(dist[node] < d)
                continue;
            
            for(int edge[]: list.get(node))
            {
                int neighbor= edge[0];
                int w= edge[1];

                long newDist= d+w;


                if(newDist > dist[neighbor])
                    continue;

                // renew the distance
                if(newDist < dist[neighbor])
                {
                    ways[neighbor]= ways[node];
                    dist[neighbor]= newDist;
                    pq.offer(new long[]{neighbor, newDist}); 
                }
    
                else
                    ways[neighbor] = (int)((0L + ways[neighbor] + ways[node]) % MOD);       
            }
        }
        return ways[n-1];
    }
}