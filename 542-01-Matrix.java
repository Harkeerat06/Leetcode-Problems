class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length, m= mat[0].length;
        int ans[][]= new int[n][m];
        boolean visit[][]= new boolean[n][m];

        Queue<int[]> q= new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(mat[i][j]==0)
                {
                    q.offer(new int[]{i,j});
                    visit[i][j]= true;
                }
            }
        }

        int dist=1;
        int direction[][]= {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty())
        {
            int size= q.size();
            for(int i=0; i<size; i++)
            {
                int arr[]= q.poll();
                for(int dir[]: direction)
                {
                    int x= arr[0] + dir[0];
                    int y= arr[1] + dir[1];

                    if(x<0 || x>=n || y<0 || y>=m || visit[x][y])
                        continue;
                    
                    if(mat[x][y]==1)
                        ans[x][y]= dist;
                    
                    visit[x][y]= true;
                    q.offer(new int[]{x,y});
                }
            }
            dist++;
        }
        return ans;
    }
}