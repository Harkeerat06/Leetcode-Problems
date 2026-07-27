class Solution {
    public int dfs(List<List<Integer>> list, boolean visit[], int node)
    {
        visit[node]= true;;
        int count=0;

        for(int i: list.get(node))
        {
            if(!visit[i])
            {
                count+= dfs(list, visit, i);
            }
        }
        return count + 1;
    }

    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> list= new ArrayList<>(); 
        int n= bombs.length;

        for(int i=0; i<n; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++)
        {
            int x1= bombs[i][0], y1= bombs[i][1];
            double r1= bombs[i][2];

            for(int j=i+1; j<n; j++)
            {
                int x2= bombs[j][0], y2= bombs[j][1];
                double r2= bombs[j][2];

                double dist= Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));

                if(dist <= r1)
                {
                    list.get(i).add(j);
                }
                if(dist <= r2)
                {
                    list.get(j).add(i);
                }
            }
        }

        int max=1;

        for(int i=0; i<n; i++)
        {
            boolean visit[]= new boolean[n];

            max= Math.max(max, dfs(list, visit, i));
        }
        return max;
    }
}