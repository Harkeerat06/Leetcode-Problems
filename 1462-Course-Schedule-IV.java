class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> list= new ArrayList<>();
        int inDeg[]= new int[numCourses];

        for(int i=0; i<numCourses; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int arr[]: prerequisites)
        {
            int u= arr[0];
            int v= arr[1];

            inDeg[v]++;
            list.get(u).add(v);
        }

        Queue<Integer> q= new LinkedList<>();
        Map<Integer, HashSet<Integer>> map= new HashMap<>();

        for(int i=0; i<numCourses; i++)
        {
            map.put(i, new HashSet<Integer>());
            if(inDeg[i]==0)
                q.offer(i);
        }


        while(!q.isEmpty())
        {
            int node= q.poll();

            for(int i: list.get(node))
            {
                map.get(i).add(node);
                map.get(i).addAll(map.get(node));
                inDeg[i]--;

                if(inDeg[i]==0)
                    q.offer(i);
            }
        }

        int qlen= queries.length;
        List<Boolean> ans= new ArrayList<>();

        for(int i=0; i<qlen; i++)
        {
            int u= queries[i][0];
            int v= queries[i][1];

            if(map.get(v).contains(u))
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}