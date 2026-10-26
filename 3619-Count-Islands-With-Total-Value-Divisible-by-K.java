class Solution {
    int findParent(int node, int parent[])
    {
        if(node == parent[node])
            return node;
        
        return parent[node]= findParent(parent[node], parent);
    }

    public void union(int u, int v, int parent[], int size[], long sum[])
    {
        int rootU= findParent(u, parent);
        int rootV= findParent(v, parent);

        if(rootU == rootV)
            return;

        if(size[rootU] < size[rootV])
        {
            int temp= rootU;
            rootU= rootV;
            rootV= temp;
        }

        parent[rootV]= rootU;
        size[rootU]+= size[rootV];
        sum[rootU]+= sum[rootV];
    }

    public int countIslands(int[][] grid, int k) {
        int n= grid.length, m= grid[0].length;
        int total= n*m;

        int parent[]= new int[total];
        int size[]= new int[total];
        long sum[]= new long[total];

        // initialize parent, size and sum
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                int id= i*m + j;

                parent[id]= id;

                if(grid[i][j] != 0)
                {
                    size[id]= 1;
                    sum[id]= grid[i][j];
                }
            }
        }

        int directions[][]= {{1,0}, {0,1}};

        // union the non-zero cells
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]==0)
                    continue;

                int id= i*m + j;

                for(int dir[]: directions)
                {
                    int x= i + dir[0];
                    int y= j + dir[1];

                    if(x<0 || x>=n || y<0 || y>=m || grid[x][y]==0)
                        continue;
                    
                    int neighId= x*m + y;
                    union(id, neighId, parent, size, sum);
                }
            }
        }

        int count=0;

        // count roots with sum divisible by k
        for(int i=0; i<total; i++)
        {
            if(size[i]>0 && parent[i] == i && sum[i]%k==0)
                count++;
        }
        return count;
    }
}