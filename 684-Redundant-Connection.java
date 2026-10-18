class Solution {
    int x, y;

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
        {
            x= u;
            y= v;
            return;
        }

        if(size[rootU] < size[rootV])
        {
            int temp= rootU;
            rootU= rootV;
            rootV= temp;
        }

        parent[rootV]= rootU;
        size[rootU]+= size[rootV];
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n= Math.max(edges[0][0], edges[0][1]);

        for(int arr[]: edges)
        {
            n= Math.max(n, Math.max(arr[0], arr[1]));
        }

        int parent[]= new int[n+1];
        int size[]= new int[n+1];
        
        for(int i=1; i<=n; i++)
        {
            parent[i]= i;
            size[i]= 1;
        }

        for(int arr[]: edges)
        {
            int u= arr[0];
            int v= arr[1];

            union(u, v, parent, size);
        }
        return new int[]{x,y};
    }
}