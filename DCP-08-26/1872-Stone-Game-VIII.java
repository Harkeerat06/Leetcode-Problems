class Solution {
    public int stoneGameVIII(int[] stones) {
        int n= stones.length;
        int prefix[]= new int[n];
        prefix[0]= stones[0];

        for(int i=1; i<n; i++)
        {
            prefix[i]= prefix[i-1] + stones[i];
        }

        int nextScore= prefix[n-1], currScore=0;
        for(int i=n-2; i>0; i--)
        {
            // (skip current, take current)
            currScore= Math.max(nextScore, prefix[i]-nextScore);
            nextScore= currScore;
        }
        return nextScore;
    }
}