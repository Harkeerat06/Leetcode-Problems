class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n= heights.length, m= heights[0].length;
        if(n==1 && m==1)
            return 0;

        int dist[][]= new int[n][m];
        for(int i=0; i<n; i++)
        {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0]= 0;
        
        PriorityQueue<int[]> q= new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        q.offer(new int[]{0, 0, 0});            // (effort, x, y)
        int directions[][]= {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty())
        {
            int arr[]= q.poll();
            int px= arr[1];
            int py= arr[2];
            if(arr[0] > dist[px][py])
                continue;
                
            if(px==n-1 && py==m-1)
                return arr[0];

            for(int dir[]: directions)
            {
                int x= px + dir[0];
                int y= py + dir[1];

                if(x<0 || x>=n || y<0 || y>=m)
                    continue;

                int currEdgeEffort= Math.abs(heights[px][py] - heights[x][y]);
                int currPathEffort= Math.max(currEdgeEffort, arr[0]);
                
                if(dist[x][y] <= currPathEffort)
                    continue;

                q.offer(new int[]{currPathEffort, x, y});
                dist[x][y]= currPathEffort;
            }
        }
        return dist[n-1][m-1];
    }
}