class Solution {
    boolean cycle= false;

    public void dfs(List<List<Integer>> list, boolean visit[], int node, boolean safe[])
    {
        for(int i: list.get(node))
        {
            if(safe[i])
                continue;

            if(cycle)
                return;

            if(visit[i])
            {
                cycle= true;
                return;
            }

            visit[i]= true;
            dfs(list, visit, i, safe);
            visit[i]= false;
            safe[i]= true;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list= new ArrayList<>();
        
        for(int i=0; i<numCourses; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int arr[]: prerequisites)
        {
            int u= arr[0];
            int v= arr[1];

            list.get(u).add(v);
        }

        boolean visit[]= new boolean[numCourses];
        boolean safe[]= new boolean[numCourses];

        for(int i=0; i<numCourses; i++)
        {
            visit[i]= true;
            dfs(list, visit, i, safe);
            visit[i]= false;

            if(cycle)
                return false;
            
            safe[i]= true;
        }
        return true;
    }
}