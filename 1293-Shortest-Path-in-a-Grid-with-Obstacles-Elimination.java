class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n= grid.length, m= grid[0].length;
        if(n==1 && m==1)
            return 0;
            
        int visit[][][]= new int[n][m][2];
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0,0});
        visit[0][0][0]= 1;

        int dist=0;
        int directions[][]= {{1,0}, {-1,0}, {0,-1}, {0,1}};

        while(!q.isEmpty())
        {
            int size= q.size();
            dist++;

            for(int i=0; i<size; i++)
            {
                int arr[]= q.poll();

                for(int dir[]: directions)
                {
                    int x= arr[0] + dir[0];
                    int y= arr[1] + dir[1];

                    if(x<0 || x>=n || y<0 || y>=m || (visit[x][y][0]==1 && visit[x][y][1]<=arr[2]))
                        continue;
                    
                    if(x==n-1 && y==m-1)
                        return dist;
                    
                    int removed= arr[2]+grid[x][y];

                    if(removed <= k)
                    {
                        q.offer(new int[]{x,y,removed});
                        visit[x][y][0]= 1;
                        visit[x][y][1]= removed;
                    }
                }
            }
        }
        return -1;
    }
}