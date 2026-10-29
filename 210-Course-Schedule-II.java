class Solution {
    boolean cycle= false;

    public void dfs(int node, List<List<Integer>> list, boolean visit[], boolean safe[], Stack<Integer> stack)
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
            dfs(i, list, visit, safe, stack);
            visit[i]= false;

            if(cycle)
                return;
            
            safe[i]= true;
        }
        stack.push(node);
    }

    public int[] findOrder(int n, int[][] prereq) {
        List<List<Integer>> list= new ArrayList<>();

        for(int i=0; i<n; i++)
            list.add(new ArrayList<>());

        for(int arr[]: prereq)
        {
            int u= arr[0];
            int v= arr[1];

            list.get(v).add(u);
        }

        boolean visit[]= new boolean[n];
        boolean safe[]= new boolean[n];
        Stack<Integer> stack= new Stack<>();

        for(int i=0; i<n; i++)
        {
            if(safe[i])
                continue;
            
            visit[i]= true;
            dfs(i, list, visit, safe, stack);
            visit[i]= false;

            if(cycle)
                return new int[]{};

            safe[i]= true; 
        }

        int ans[]= new int[n];
        for(int i=0; i<n; i++)
        {
            ans[i]= stack.pop();
        }
        return ans;
    }
}