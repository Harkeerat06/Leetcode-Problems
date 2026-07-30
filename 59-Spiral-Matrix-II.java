class Solution {
    public int[][] generateMatrix(int n) {
        int rowStart=0, rowEnd= n-1;
        int colStart=0, colEnd= n-1;
        int i=0, j=0, val=1;
        int ans[][]= new int[n][n];

        while(true)
        {
            // move left to right
            for(i=rowStart, j=colStart; j<=colEnd; j++)
            {
                ans[i][j]= val;
                val++;
            }
            rowStart++;
            if(rowStart>rowEnd) break;
            
            // move top to bottom
            for(i=rowStart, j=colEnd; i<=rowEnd; i++)
            {
                ans[i][j]= val;
                val++;
            }
            colEnd--;
            if(colStart>colEnd) break;

            // move right to left
            for(i=rowEnd, j=colEnd; j>=colStart; j--)
            {
                ans[i][j]= val;
                val++;
            }
            rowEnd--;
            if(rowStart>rowEnd) break;

            // move bottom to top
            for(i=rowEnd, j=colStart; i>=rowStart; i--)
            {
                ans[i][j]= val;
                val++;
            }
            colStart++;
            if(colStart>colEnd) break;
        }
        return ans;
    }
}