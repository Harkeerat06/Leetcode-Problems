class Solution {
    public int[] findOrder(int n, int[][] prereq) {
        List<List<Integer>> list= new ArrayList<>();
        int indegree[]= new int[n];
        
        for(int i=0; i<n; i++)
            list.add(new ArrayList<>());

        for(int pre[]: prereq)
        {
            int course= pre[0];
            int prerequisite= pre[1];

            list.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q= new LinkedList<>();

        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
                q.offer(i);
        }

        int ans[]= new int[n];
        int index=0, visited=0;

        while(!q.isEmpty())
        {
            int node= q.poll();
            ans[index++]= node;
            visited++;

            for(int i: list.get(node))
            {
                indegree[i]--;
            
                if(indegree[i] == 0)    
                    q.offer(i);
            }
        }
        if(visited!=n)
            return new int[]{};
        
        return ans;
    }
}