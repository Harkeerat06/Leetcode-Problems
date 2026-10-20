class Solution {
    int edgeCount, size;

    public void dfs(int node, List<List<Integer>> list, boolean visit[])
    {
        visit[node]= true;
        size++;
        List<Integer> neigh= list.get(node);
        edgeCount+= neigh.size();

        for(int i: neigh)
        {
            if(visit[i])
                continue;

            dfs(i, list, visit);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> list= new ArrayList<>();
        
        for(int i=0; i<n; i++)
            list.add(new ArrayList<>());

        for(int arr[]: edges)
        {
            int u= arr[0];
            int v= arr[1];

            list.get(v).add(u);
            list.get(u).add(v);
        }

        boolean visit[]= new boolean[n];
        int count=0;
        
        for(int i=0; i<n; i++)
        {
            if(visit[i])
                continue;
            
            size=0;
            edgeCount=0;
            dfs(i, list, visit);

            if(size * (size-1) <= edgeCount)
                count++;
        }
        return count;
    }
}