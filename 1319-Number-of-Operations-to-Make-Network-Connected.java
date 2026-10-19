class Solution {
    public void dfs(int node, List<List<Integer>> list, boolean visit[])
    {
        visit[node]= true;
        List<Integer> neigh= list.get(node);

        for(Integer i: neigh)
        {
            if(visit[i])
                continue;
            
            dfs(i, list, visit);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)
            return -1;
        
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(new ArrayList<>());
        
        for(int arr[]: connections)
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
            
            dfs(i, list, visit);
            count++;
        }
        
        return count-1;
    }
}