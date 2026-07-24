class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        boolean visit[][]= new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();
        int c1=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                    visit[i][j]= true;
                }
                else if(grid[i][j]==1)
                    c1++;
            }
        }

        int r1=0, mins=-1;
        while(!q.isEmpty())
        {
            mins++;
            int size= q.size();

            for(int x=0; x<size; x++)
            {
                int arr[]= q.poll();
                int i= arr[0], j= arr[1];

                // check down
                if(i<n-1 && grid[i+1][j]==1 && !visit[i+1][j])
                {
                    r1++;
                    q.offer(new int[]{i+1, j});
                    visit[i+1][j]= true;
                }

                // check above
                if(i>0 && grid[i-1][j]==1 && !visit[i-1][j])
                {
                    r1++;
                    q.offer(new int[]{i-1, j});
                    visit[i-1][j]= true;
                }

                // check left
                if(j>0 && grid[i][j-1]==1 && !visit[i][j-1])
                {
                    r1++;
                    q.offer(new int[]{i, j-1});
                    visit[i][j-1]= true;
                }

                // check right
                if(j<m-1 && grid[i][j+1]==1 && !visit[i][j+1])
                {
                    r1++;
                    q.offer(new int[]{i, j+1});
                    visit[i][j+1]= true;
                }
            }
        }

        if(c1!=0 && r1==c1)
            return mins;
        if(c1==0)
            return 0;

        return -1;
    }
}