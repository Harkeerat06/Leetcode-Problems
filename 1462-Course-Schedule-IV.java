class Solution {
    public boolean dfs(int start, int dest, List<List<Integer>> list, boolean visit[])
    {
        if(start == dest)
            return true;
        
        visit[start]= true;

        for(int i: list.get(start))
        {
            if(!visit[i] && dfs(i, dest, list, visit))
                return true;
        }
        return false;
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prereq, int[][] queries) {
        List<List<Integer>> list= new ArrayList<>();

        for(int i=0; i<n; i++)
            list.add(new ArrayList<>());

        for(int pre[]: prereq)
        {
            int u= pre[0];
            int v= pre[1];

            list.get(u).add(v);
        }

        List<Boolean> ans= new ArrayList<>();
        boolean visit[];
        
        for(int q[]: queries)
        {
            visit= new boolean[n];
            int start= q[0];
            int dest= q[1];

            if(dfs(start, dest, list, visit))
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}