class Solution {
    public int findParent(int node, int parent[])
    {
        if(node == parent[node])
            return node;
        
        return parent[node]= findParent(parent[node], parent);
    }

    public void union(int u, int v, int parent[], int size[])
    {
        int rootU= findParent(u, parent);
        int rootV= findParent(v, parent);

        if(rootU == rootV)
            return;
        
        if(size[rootV] > size[rootU])
        {
            int temp= rootU;
            rootU= rootV;
            rootV= temp;
        }

        parent[rootV]= rootU;
        size[rootU]+= size[rootV];
    }

    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int parent[]= new int[n];
        int size[]= new int[n];

        for(int i=0; i<n; i++)
        {
            parent[i]= i;
            size[i]= 1;
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(isConnected[i][j]==1)
                    union(i, j, parent, size);
            }
        }

        int count=0;

        for(int i=0; i<n; i++)
        {
            if(parent[i]==i)
                count++;
        }
        return count;
    }
}