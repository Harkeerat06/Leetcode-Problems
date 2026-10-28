class Solution {
    boolean cycle= false;

    public void dfs(int node, List<List<Integer>> list, boolean visit[], boolean safe[])
    {
        for(int i: list.get(node))
        {
            if(safe[i])
                continue;
            
            if(visit[i])
            {
                cycle= true;
                return;
            }

            visit[i]= true;
            dfs(i, list, visit, safe);
            visit[i]= false;

            if(cycle)
                return;
            
            safe[i]= true;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list= new ArrayList<>();

        for(int i=0; i<numCourses; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int pre[]: prerequisites)
        {
            int u= pre[0];
            int v= pre[1];

            list.get(u).add(v);
        }

        boolean visit[]= new boolean[numCourses];
        boolean safe[]= new boolean[numCourses];

        for(int i=0; i<numCourses; i++)
        {
            if(safe[i])
                continue;
            
            visit[i]= true;
            dfs(i, list, visit, safe);
            visit[i]= false;

            if(cycle)
                return false;
            
            safe[i]= true;
        }
        return true;
    }
}