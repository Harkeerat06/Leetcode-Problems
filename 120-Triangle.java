class Solution {
    public int findMinSum(int row, int col, int memo[][], List<List<Integer>> list, int n)
    {
        if(row==n-1)
        {
            memo[row][col]= list.get(row).get(col);
            return memo[row][col];
        }

        if(memo[row][col] != Integer.MIN_VALUE)
            return memo[row][col];

        
        memo[row][col]= list.get(row).get(col);

        // take curr col then next col
        memo[row][col]+= Math.min(findMinSum(row+1, col, memo, list, n), findMinSum(row+1, col+1, memo, list, n));

        return memo[row][col];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        int memo[][]= new int[n][];
        for(int i=0; i<n; i++)
        {
            memo[i]= new int[i+1];
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        return findMinSum(0, 0, memo, triangle, n);
    }
}