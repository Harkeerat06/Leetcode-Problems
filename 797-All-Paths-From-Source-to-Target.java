class Solution {
    List<List<Integer>> ans= new ArrayList<>();

    public void dfs(List<Integer> path, int[][] graph, int i, boolean visit[], int n)
    {
        if(i==n-1)
        {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j: graph[i])
        {
            if(!visit[j])
            {
                path.add(j);
                visit[j]= true;

                dfs(path, graph, j, visit, n);

                visit[j]= false;
                path.remove(path.size()-1);
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n= graph.length;
        boolean visit[]= new boolean[n];

        List<Integer> path= new ArrayList<>();
        visit[0]= true;
        path.add(0);
        dfs(path, graph, 0, visit, n);
        
        return ans;
    }
}