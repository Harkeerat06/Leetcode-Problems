class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        boolean pacific[][]= new boolean[n][m];
        boolean atlantic[][]= new boolean[n][m];

        int directions[][]= {{1,0}, {-1,0}, {0,-1}, {0,1}};
        Queue<int[]> q1= new LinkedList<>();
        Queue<int[]> q2= new LinkedList<>();
        boolean visit1[][]= new boolean[n][m];
        boolean visit2[][]= new boolean[n][m];

        // first and last column
        for(int i=0; i<n; i++)
        {
            q1.offer(new int[]{i, m-1});
            visit1[i][m-1]= true;
            atlantic[i][m-1]= true;

            q2.offer(new int[]{i,0});
            visit2[i][0]= true;
            pacific[i][0]= true;

        }
        
        // first and last row
        for(int i=0; i<m; i++)
        {
            q1.offer(new int[]{n-1, i});
            visit1[n-1][i]= true;
            atlantic[n-1][i]= true;

            q2.offer(new int[]{0, i});
            visit2[0][i]= true;
            pacific[0][i]= true;
        }


        // check for atlantic ocean
        while(!q1.isEmpty())
        {
            int arr[]= q1.poll();
            for(int dir[]: directions)
            {
                int x= arr[0] + dir[0];
                int y= arr[1] + dir[1];

                if(x<0 || x>=n || y<0 || y>=m || grid[x][y] < grid[arr[0]][arr[1]] || visit1[x][y])
                    continue;
                    
                visit1[x][y]= true;
                atlantic[x][y]= true;
                q1.offer(new int[]{x,y});
            }
        }

        // check for atlantic ocean
        while(!q2.isEmpty())
        {
            int arr[]= q2.poll();
            for(int dir[]: directions)
            {
                int x= arr[0] + dir[0];
                int y= arr[1] + dir[1];

                if(x<0 || x>=n || y<0 || y>=m || grid[x][y] < grid[arr[0]][arr[1]] || visit2[x][y])
                    continue;
                
                visit2[x][y]= true;
                pacific[x][y]= true;
                q2.offer(new int[]{x,y});
            }
        }

        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                    list.add(Arrays.asList(i,j));
            }
        }
        return list;
    }
}