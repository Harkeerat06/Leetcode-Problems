class Solution {
    public boolean dfs(int node, int target, List<List<Integer>> list, boolean visit[])
    {
        if(node == target)
            return true;
        
        visit[node]= true;
        List<Integer> neigh= list.get(node);

        for(int i: neigh)
        {
            if(visit[i])
                continue;
            
            if(dfs(i, target, list, visit))
                return true;
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination)
            return true;
            
        if(edges.length == 0)
            return false;

        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int arr[]: edges)
        {
            int u= arr[0];
            int v= arr[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean visit[]= new boolean[n];

        return dfs(source, destination, list, visit);
    }
}