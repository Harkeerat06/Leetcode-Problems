class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list= new ArrayList<>();
        for(int i=0; i<=n; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int arr[]: times)
        {
            int u= arr[0];
            int v= arr[1];
            int w= arr[2];

            list.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> q= new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int dist[]= new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]= 0;
        q.offer(new int[]{k,0});

        while(!q.isEmpty())
        {
            int arr[]= q.poll();
            int curr= arr[0];
            int d= arr[1];
            
            if(d > dist[curr])
                continue;

            for(int pair[]: list.get(arr[0]))
            {
                int next= pair[0];
                int addDist= pair[1];

                if(dist[next] > addDist + d)
                {
                    dist[next] = addDist + d;
                    q.offer(new int[]{next, addDist+d});
                }

            }
        }

        int max= dist[1];
        for(int i=1; i<=n; i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
                return -1;
            
            max= Math.max(max, dist[i]);
        }
        return max;
    }
}