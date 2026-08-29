class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int sumSource= source[0]+source[1];
        int sumTarget= target[0]+target[1];

        // if target and source are different coloured
        if(sumSource%2!=0 && sumTarget%2==0 || sumSource%2==0 && sumTarget%2!=0)
            return -1;

        int sx= source[0], sy= source[1];
        int tx= target[0], ty= target[1];

        if(Math.abs(sx-tx)==Math.abs(sy-ty))
            return 1;

        return 2;
    }
}