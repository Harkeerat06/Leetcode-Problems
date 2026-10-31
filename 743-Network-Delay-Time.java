class Solution {
    int INF= 1_000_000_000;

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list= new ArrayList<>();
        for(int i=0; i<=n; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int edge[]: times)
        {
            int src= edge[0];
            int target= edge[1];
            int d= edge[2];

            list.get(src).add(new int[]{target, d});
        }

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        int dist[]= new int[n+1];
        Arrays.fill(dist, INF);
        dist[k]= 0;
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty())
        {
            int edge[]= pq.poll();

            int node= edge[0];
            int d= edge[1];

            if(d > dist[node])
                continue;
            
            for(int arr[]: list.get(node))
            {
                int neighbor= arr[0];
                int w= arr[1];

                if(dist[neighbor] > d+w)
                {
                    dist[neighbor]= d+w;
                    pq.offer(new int[]{neighbor, d+w});
                }
            }
        }

        int max= 0;
        for(int i=1; i<=n; i++)
        {
            if(dist[i] == INF)
                return -1;

            max= Math.max(max, dist[i]);
        }
        return max;
    }
}