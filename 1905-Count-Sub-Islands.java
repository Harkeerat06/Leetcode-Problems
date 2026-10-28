class Solution {
    public int findParent(int node, int parent[])
    {
        if(node == parent[node])
            return node;
        
        return parent[node]= findParent(parent[node], parent);
    }

    public void union(int u, int v, int parent[], int size[], boolean valid[])
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
        valid[rootU] &= valid[rootV];
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n= grid1.length, m= grid1[0].length;

        // assign parent and size
        int parent[]= new int[n*m];
        int size[]= new int[n*m];
        boolean valid[]= new boolean[n*m];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid2[i][j]==0)
                    continue;

                int id= i*m + j;

                parent[id]= id;
                size[id]= 1;

                if(grid1[i][j] == 1)
                    valid[id]= true;
                else
                    valid[id]= false;
            }
        }

        // union all islands one by one
        int directions[][]= {{0,1}, {1,0}};

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid2[i][j] == 0)
                    continue;

                int id= i*m + j;

                for(int dir[]: directions)
                {
                    int x= i + dir[0];
                    int y= j + dir[1];

                    if(x<0 || x>=n || y<0 || y>=m || grid2[x][y]==0)
                        continue;
                    
                    int neighId= x*m + y;

                    union(id, neighId, parent, size, valid);
                }
            }
        }

        int count= 0;
        for(int i=0; i<n*m; i++)
        {
            if(parent[i] == i && valid[i])
                count++;
        }
        return count;
    }
}