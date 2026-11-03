class Solution {
    public boolean checkDiscard(int node, int currCost, int countFlights, List<List<int[]>> nodeStates)
    {
        boolean discard= false;
        for(int st[]: nodeStates.get(node))
        {
            int prevCost= st[0], prevFlights= st[1];

            // the inner OR condition is to avoid comparing with state we just popped and was inserted into nodeStates when pushing in queue
            if(currCost >= prevCost && countFlights >= prevFlights &&
                (prevCost < currCost || prevFlights < countFlights))
            {
                discard= true;
                break;
            }
        }
        return discard;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> list= new ArrayList<>();
        List<List<Integer>> reverse= new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            list.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for(int arr[]: flights)
        {
            int u= arr[0];
            int v= arr[1];
            int price= arr[2];

            list.get(u).add(new int[]{v, price});
            reverse.get(v).add(u);
        }

        // Find min flights from each node to destination
        int minFlights[]= new int[n];
        Arrays.fill(minFlights, Integer.MAX_VALUE);
        minFlights[dst]= 0;
        Queue<Integer> q= new LinkedList<>();
        q.offer(dst);

        while(!q.isEmpty())
        {
            int node= q.poll();
            int fl= minFlights[node];

            for(int i: reverse.get(node))
            {
                if(minFlights[i]!=Integer.MAX_VALUE)
                    continue;

                minFlights[i]= fl+1;
                q.offer(i);
            }
        }

        // initialize the array 
        List<List<int[]>> nodeStates = new ArrayList<>();       //{cost, flights}
        for(int i=0; i<n; i++)
        {
            nodeStates.add(new ArrayList<>());
        }
        nodeStates.get(src).add(new int[]{0, 0});
        
        // Start from source and keep storing flights
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{src, 0, 0});         // {node, cost, flights}

        while(!pq.isEmpty())
        {
            int arr[]= pq.poll();
            int node= arr[0];
            int currCost= arr[1];
            int countFlights= arr[2];

            // discard current state if remaining flights < min needed flights
            if(countFlights+minFlights[node] > k+1)
                continue;

            // loop over states and discard if curr state is fully dominated
            if(checkDiscard(node, currCost, countFlights, nodeStates))
                continue;

            
            // loop over neighbour of current node and add new states
            for(int edge[]: list.get(node))
            {
                int neighbor= edge[0];
                int neighborCost= edge[1];

                int newCost= currCost + neighborCost;
                int newFlightCount= countFlights + 1;

                // again discard the new state if it is fully dominated by another state
                if(checkDiscard(neighbor, newCost, newFlightCount, nodeStates) || newFlightCount > k + 1)
                    continue;
                
                nodeStates.get(neighbor).add(new int[]{newCost, newFlightCount});
                pq.offer(new int[]{neighbor, newCost, newFlightCount});
            }
        }

        // find the state with min cost for the dst node
        int minCost= Integer.MAX_VALUE; 
        for(int arr[]: nodeStates.get(dst))
        {
            minCost= Math.min(minCost, arr[0]);
        }
        if(minCost==Integer.MAX_VALUE)
            return -1;
        return minCost;
    }
}