class Solution {
    public boolean canVisit(int node, int target, List<List<Integer>> list, boolean visit[])
    {
        visit[node]= true;

        for(int i: list.get(node))
        {
            if(i==target)
                return true;
            
            if(!visit[i])
            {
                if(canVisit(i, target, list, visit))
                    return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n= Math.max(edges[0][0], edges[0][1]);
        for(int arr[]: edges)
        {
            n= Math.max(n, Math.max(arr[0], arr[1]));
        }

        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<=n; i++)
        {
            list.add(new ArrayList<>());
        }

        int elen= edges.length;
        int x= -1, y= -1;

        for(int i=0; i<elen; i++)
        {
            int u= edges[i][0];
            int v= edges[i][1];

            boolean visit[]= new boolean[n+1];
            if(canVisit(u, v, list, visit))
            {
                x= u;
                y= v;
            }

            list.get(u).add(v);
            list.get(v).add(u);
        }
        return new int[]{x,y};
    }
}