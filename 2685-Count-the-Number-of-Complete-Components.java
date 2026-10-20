class Solution {
    public int findParent(int node, int parent[])
    {
        if(node == parent[node])
            return node;
        
        return parent[node]= findParent(parent[node], parent);
    }

    public void union(int u, int v, int parent[], int size[], int edgeCount[])
    {
        int rootU= findParent(u, parent);
        int rootV= findParent(v, parent);

        if(rootU == rootV)
        {
            edgeCount[rootU]++;
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
        edgeCount[rootU]+= edgeCount[rootV] + 1;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int parent[]= new int[n];
        int edgeCount[]= new int[n];
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

            union(u, v, parent, size, edgeCount);
        }

        int count=0;

        for(int i=0; i<n; i++)
        {
            if(parent[i] != i)
                continue;
            
            int s= size[i];
            int ec= edgeCount[i];

            if(s*(s-1)/2 == ec)
                count++;
        }
        return count;
    }
}