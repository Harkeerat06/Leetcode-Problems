class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost=0, n= colors.length();
        int i=0, j=0;
        char arr[]= colors.toCharArray();

        while(j<n-1)
        {
            int sum= neededTime[j], max= neededTime[j];
            
            while(j<n-1 && arr[j] == arr[j+1])
            {
                sum+= neededTime[j+1];
                max= Math.max(max, neededTime[j+1]);
                j++;
            }
            if(j-i+1 > 1)
                cost+= sum - max;
            j++;
            i=j;
        }
        return cost;
    }
}