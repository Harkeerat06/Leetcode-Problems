class Solution {
    boolean cycle= false;

    public void dfs(List<List<Integer>> list, boolean visit[], int node, Stack<Integer> stack, boolean safe[])
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
            dfs(list, visit, i, stack, safe);
            visit[i]= false;
            
            if(cycle)
                return;
            
            safe[i]= true;
        }
        stack.push(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<numCourses; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int arr[]: prerequisites)
        {
            int u= arr[0];
            int v= arr[1];

            list.get(u).add(v);
        }
        

        boolean safe[]= new boolean[numCourses];
        boolean visit[]= new boolean[numCourses];
        Stack<Integer> stack= new Stack<>();

        for(int i=0; i<numCourses; i++)
        {
            if(safe[i])
                continue;
                
            if(!visit[i])
            {
                visit[i]= true;
                dfs(list, visit, i, stack, safe);
                visit[i]= false;
            }
            if(cycle)
                return new int[]{};
            
            safe[i]= true;
        }

        int ans[]= new int[numCourses];
        for(int i=numCourses-1; i>=0; i--)
        {
            ans[i]= stack.pop();
        }
        return ans;
    }
}