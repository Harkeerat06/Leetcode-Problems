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
        
        if(size[rootV] > size[rootU])
        {
            int temp= rootU;
            rootU= rootV;
            rootV= temp;
        }

        parent[rootV]= rootU;
        size[rootU]+= size[rootV];
    }

    public long countPairs(int n, int[][] edges) {
        int parent[]= new int[n];
        int size[]= new int[n];

        for(int i=0; i<n; i++)
        {
            parent[i]= i;
            size[i]= 1;
        }

        for(int edge[]: edges)
        {
            union(edge[0], edge[1], parent, size);
        }

        long remaining= n;
        long count=0;

        for(int i=0; i<n; i++)
        {
            if(parent[i] != i)
                continue;
            
            count+= size[i] * (remaining - size[i]);
            remaining-= size[i];
        }
        return count;
    }
}