class Solution {
    int count=1;

    public void dfs(List<List<Integer>> list, boolean visit[], int i)
    {
        visit[i]= true;

        for(int j: list.get(i))
        {
            if(!visit[j])
            {
                count++;
                dfs(list, visit, j);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean visit[]= new boolean[n];
        List<Integer> start= new ArrayList<>();

        for(int i: rooms.get(0))
            start.add(i);
        
        visit[0]= true;

        for(int i: start)
        {
            if(!visit[i])
            {
                count++;
                dfs(rooms, visit, i);
            }
        }
        return count==n;
    }
}