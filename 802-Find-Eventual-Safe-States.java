class Solution {
    public boolean dfs(int[][] graph, boolean visit[], boolean isSafe[], boolean isUnsafe[], int node)
    {
        if(isSafe[node])
            return false;
        else if(isUnsafe[node] || visit[node])
            return true;
        
        visit[node]= true;

        for(int i: graph[node])
        {
            if(dfs(graph, visit, isSafe, isUnsafe, i))
            {
                isUnsafe[node]= true;
                visit[node]= false;
                return true;
            }
        }

        visit[node]= false;
        isSafe[node]= true;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;
        boolean isSafe[]= new boolean[n];
        boolean isUnsafe[]= new boolean[n];
        List<Integer> list= new ArrayList<>();
        boolean visit[]= new boolean[n];

        for(int i=0; i<n; i++)
        {
            if(!dfs(graph, visit, isSafe, isUnsafe, i))   // true if cycle found
            {
                list.add(i);
            }
        }
        return list;
    }
}