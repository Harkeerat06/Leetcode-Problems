class Solution {
    public int minMoves(int[] nums) {
        int max= 0;
        for(int i: nums)
            max= Math.max(i, max);

        int moves=0;
        for(int i: nums)
            moves+= max-i;
        return moves;
    }
}