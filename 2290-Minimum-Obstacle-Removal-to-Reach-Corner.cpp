class Solution {
    public int minimumObstacles(int[][] grid) {
        int n= grid.length, m= grid[0].length;

        int directions[][]= {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int obsCount[][]= new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(obsCount[i], Integer.MAX_VALUE);
        obsCount[0][0]= 0;

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty())
        {
            int arr[]= pq.poll();
            int i= arr[0], j= arr[1];
            int wallCount= arr[2];

            if(wallCount > obsCount[i][j])
                continue;
            
            for(int dir[]: directions)
            {
                int x= i + dir[0];
                int y= j + dir[1];

                if(x<0 || x>=n || y<0 || y>=m)
                    continue;
                
                int newWallCount= grid[x][y]==1 ? wallCount+1 : wallCount;
                
                if(newWallCount < obsCount[x][y])
                {
                    obsCount[x][y]= newWallCount;
                    pq.offer(new int[]{x, y, newWallCount});
                }
            }
        }
        return obsCount[n-1][m-1];
    }
}