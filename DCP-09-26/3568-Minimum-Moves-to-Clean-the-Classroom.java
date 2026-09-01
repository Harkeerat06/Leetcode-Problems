class Solution {
    public int minMoves(String[] room, int energy)
    {
        int n= room.length, m= room[0].length();
        int dist=0, reset= energy;
        int startX=-1, startY=-1, totalCount=0;
        int litterBit[][]= new int[n][m];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(room[i].charAt(j) == 'L')
                {
                    litterBit[i][j]= totalCount;
                    totalCount++;
                }
            
                else if(room[i].charAt(j) == 'S')
                {
                    startX= i;
                    startY= j;
                }
            }
        }
        if(totalCount==0)
            return 0;

        int finalMask= (int)Math.pow(2, totalCount) - 1;

        boolean visited[][][][]= new boolean[n][m][energy+1][1<<totalCount];
        Queue<int[]> q= new LinkedList<>();
        int directions[][]= {{0,-1}, {-1,0}, {0,1}, {1,0}};

        q.offer(new int[]{startX, startY, energy, 0});
        visited[startX][startY][energy][0]= true;

        while(!q.isEmpty())
        {
            int size= q.size();

            while(size-- > 0)
            {
                int arr[]= q.poll();
                int cx= arr[0], cy= arr[1];
                int currEnergy= arr[2], currMask= arr[3];

                if(currMask == finalMask)
                    return dist;
                
                /* We checked here because inside the next loop, we will have to check 2 cases
                1) if energy is 0 but this is my last litter cell
                2) if energy is 0 but this isnt the last litter cell
                So instead we just use a single condition outside which covers both cases */
                if(currEnergy==0)      
                    continue;

                for(int dir[]: directions)
                {
                    int x= cx + dir[0];
                    int y= cy + dir[1];
                    int newMask= currMask;
                    int newEnergy= currEnergy - 1;

                    if(x<0 || x>=n || y<0 || y>=m)
                        continue;

                    char ch= room[x].charAt(y);

                    if(ch=='X')
                        continue;

                    if(ch=='R')
                        newEnergy= reset;
                    
                    if(ch=='L')
                    {
                        newMask|= (1 << litterBit[x][y]);
                    }

                    if(visited[x][y][newEnergy][newMask])
                        continue;

                    q.offer(new int[]{x,y, newEnergy, newMask});
                    visited[x][y][newEnergy][newMask]= true;
                }
            }
            dist++;
        }

        return -1;
    }
}