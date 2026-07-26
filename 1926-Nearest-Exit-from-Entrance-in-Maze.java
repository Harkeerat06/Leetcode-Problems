class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n= maze.length, m= maze[0].length;
        boolean visit[][]= new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1]});
        visit[entrance[0]][entrance[1]]= true;

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

                    if(x<0 || x>=n || y<0 || y>=m || maze[x][y]=='+' || visit[x][y])
                        continue;
                    
                    if(x==0 || y==0 || x==n-1 || y==m-1)
                        return dist;
                    
                    visit[x][y]= true;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return -1;
    }
}