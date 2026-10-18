class Solution {
    public boolean dfs(int node, int graph[][], boolean visit[], boolean isSafe[], boolean isUnsafe[])
    {
        if(isSafe[node])
            return false;

        if(isUnsafe[node] || visit[node])
            return true;
        
        visit[node]= true;

        for(int i: graph[node])
        {
            if(dfs(i, graph, visit, isSafe, isUnsafe))
            {
                isUnsafe[i]= true;
                visit[node]= false;
                return true;
            }
        }

        isSafe[node]= true;
        visit[node]= false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;
        boolean isSafe[]= new boolean[n];
        boolean isUnsafe[]= new boolean[n];
        boolean visit[]= new boolean[n];

        List<Integer> list= new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            if(!dfs(i, graph, visit, isSafe, isUnsafe))     // returns true if loop found
            {
                list.add(i);
            }
        }
        return list;
    }
}