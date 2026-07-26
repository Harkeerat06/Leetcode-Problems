class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n= grid.length, m= grid[0].length;
        boolean visit[][]= new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0,0});
        visit[0][0]= true;

        int dist=0;
        int directions[][]= {{1,0}, {-1,0}, {0,-1}, {0,1}};

        while(!q.isEmpty())
        {
            int size= q.size();
            dist++;

            for(int i=0; i<size; i++)
            {
                int arr[]= q.poll();
                if(arr[2]>k)
                    continue;

                for(int dir[]: directions)
                {
                    int x= arr[0] + dir[0];
                    int y= arr[1] + dir[1];

                    if(x<0 || x>=n || y<0 || y>=m || visit[x][y])
                        continue;
                    
                    if(x==n-1 && y==m-1)
                        return dist;
                    
                    q.offer(new int[]{x,y, arr[2]+grid[x][y] });
                    visit[x][y]= true;
                }
            }
        }
        return -1;
    }
}