class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        boolean visit[][]= new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();

        if(grid[0][0]==1 || grid[n-1][m-1]==1)
            return -1;
        
        if(grid[0][0]==0 && m==1 && n==1)
            return 1;
        
        int dist=1;
        int direction[][]= {{0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
        q.offer(new int[]{0,0});
        visit[0][0]= true;

        while(!q.isEmpty())
        {
            int size= q.size();
            dist++;

            for(int i=0; i<size; i++)
            {
                int arr[]= q.poll();
                for(int dir[]: direction)
                {
                    int x= arr[0] + dir[0];
                    int y= arr[1] + dir[1];

                    if(x<0 || x>=n || y<0 || y>=m || visit[x][y] || grid[x][y]==1)
                        continue;
                    
                    visit[x][y]= true;
                    if(x==n-1 && y==m-1)
                        return dist;
                    
                    q.offer(new int[]{x,y});
                }
            }
        }
        return -1;
    }
}