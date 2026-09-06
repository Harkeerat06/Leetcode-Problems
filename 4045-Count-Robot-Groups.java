class Solution {
    public int countGroups(int[] pos, int[] speed, int distance) {
        int n= pos.length, groups=1;  
        if(n==1)
            return 1;

        int gp[]= new int[n];
        int gs[]= new int[n];
        gp[0] = pos[0];
        gs[0] = speed[0];
        int m=0;

        for(int i=1; i<n; i++)
        {
            if(pos[i]-distance <= pos[i-1])
            {
                gp[m]= pos[i];
                gs[m]= speed[i];
            }
            else
            {
                m++;
                gp[m]= pos[i];
                gs[m]= speed[i];
            }
        }

        if(m==0)
            return 1;
        
        int i=m;
        while(i>0)
        {
            if(gs[i] < gs[i-1])
            {
                gs[i-1]= gs[i];
            }
            else
                groups++;

            i--;
        }
        return groups;
    }
}