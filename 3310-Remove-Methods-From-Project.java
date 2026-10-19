class Solution {
    public void dfs(int node, List<List<Integer>> list, boolean isSus[])
    {
        isSus[node]= true;
        List<Integer> neighbour= list.get(node);
        
        for(int i: neighbour)
        {
            if(isSus[i])
                continue;
            
            dfs(i, list, isSus);
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] edges) {
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(new ArrayList<>());
        
        for(int arr[]: edges)
        {
            int u= arr[0];
            int v= arr[1];
            list.get(u).add(v);
        }

        boolean isSus[]= new boolean[n];
        dfs(k, list, isSus);

        // check if any normal node gets connected with suspicious node
        boolean takeAll= false;

        for(int arr[]: edges)
        {
            int u= arr[0];
            int v= arr[1];
            
            if(!isSus[u] && isSus[v])
            {
                takeAll= true;
                break;
            }
        }

        List<Integer> ans= new ArrayList<>();
        if(takeAll)
        {
            for(int i=0; i<n; i++)
                ans.add(i);
        }
        else
        {
            for(int i=0; i<n; i++)
            {
                if(!isSus[i])
                    ans.add(i);
            }
        }
        return ans;
    }
}