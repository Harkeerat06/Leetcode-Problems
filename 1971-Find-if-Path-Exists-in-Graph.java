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
        
        if(size[rootU] < size[rootV])
        {
            int temp= rootU;
            rootU= rootV;
            rootV= temp;
        }

        parent[rootV]= rootU;
        size[rootU]+= size[rootV];
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)
            return true;
        
        if(edges.length==0)
            return false;

        int parent[]= new int[n];
        int size[]= new int[n];

        for(int i=0; i<n; i++)
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

        int rootS= findParent(source, parent);
        int rootT= findParent(destination, parent);

        return rootS == rootT;
    }
}