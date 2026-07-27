class Solution {
    int extra=0;

    public void dfs(List<List<Integer>> list, boolean visit[], int node, int prev)
    {
        visit[node]= true;

        for(int i: list.get(node))
        {
            if(visit[i])
            {
                if(i!=prev)
                    extra++;
                continue;
            }
            dfs(list, visit, i, node);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int arr[]: connections)
        {
            int u= arr[0];
            int v= arr[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean visit[]= new boolean[n];
        int components=0;

        for(int i=0; i<n; i++)
        {
            if(!visit[i])
            {
                components++;
                dfs(list, visit, i, -1);
            }
        }
        if(components>1 && components > extra)
            return -1;
        
        return components-1;
    }
}