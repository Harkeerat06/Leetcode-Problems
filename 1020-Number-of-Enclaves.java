class Solution {
    public int findParent(int node, int parent[])
    {
        if(parent[node] == node)
            return node;
        
        return parent[node]= findParent(parent[node], parent);
    }

    public void union(int u, int v, int parent[], int size[])
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
    }

    public int numEnclaves(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        int boundary= n*m;

        int parent[]= new int[boundary + 1];
        int size[]= new int[boundary + 1];

        for(int i=0; i<=boundary; i++)
        {
            parent[i]= i;
            size[i]= 1;
        }

        int directions[][]= {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 0)
                    continue;
                
                int id= i*m + j;

                // connect boundary land to the virtual node with value= n*m
                if(i==0 || j==0 || i==n-1 || j==m-1)
                    union(boundary, id, parent, size);
                
                for(int dir[]: directions)
                {
                    int x= i + dir[0];
                    int y= j + dir[1];
                    
                    if(x<0 || x>=n || y<0 || y>=m || grid[x][y]==0)
                        continue;
                    
                    int neighbourId= x*m + y;
                    union(id, neighbourId, parent, size);
                }
            }
        }

        int count= 0;
        int boundaryRoot= findParent(boundary, parent);

        for (int i=0; i<n; i++) 
        {
            for (int j=0; j<m; j++) 
            {
                if(grid[i][j] == 0) 
                    continue;

                int id= i*m + j;

                if(findParent(id, parent) != boundaryRoot)
                    count++;
            }
        }
        return count;
    }
}