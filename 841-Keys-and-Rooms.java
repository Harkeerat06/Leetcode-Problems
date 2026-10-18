class Solution {
    int count;

    public void dfs(int node, List<List<Integer>> list, boolean visit[])
    {
        count++;
        visit[node]= true;

        for(Integer i: list.get(node))
        {
            if(visit[i])
                continue;
            
            dfs(i, list, visit);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> list) {
        int n= list.size();
        boolean visit[]= new boolean[n];
        
        dfs(0, list, visit);
        return count==n;
    }
}