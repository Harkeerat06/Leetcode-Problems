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

        if(size[rootU] < size[rootV])
        {
            int temp= rootU;
            rootU= rootV;
            rootV= temp;
        }

        parent[rootV]= rootU;
        size[rootU]+= size[rootV];
    }

    public int makeConnected(int n, int[][] connections) {
        if(n-1 > connections.length)
            return -1;

        int parent[]= new int[n];
        int size[]= new int[n];

        for(int i=0; i<n; i++)
        {
            parent[i]= i;
            size[i]= 1;
        }

        for(int arr[]: connections)
        {
            int u= arr[0];
            int v= arr[1];

            union(u,v, parent, size);
        }

        int count= 0;
        for(int i=0; i<n; i++)
        {
            if(parent[i] == i)
                count++;
        }
        return count -1;
    }
}