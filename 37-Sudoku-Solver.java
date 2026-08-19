class Solution {
    int currRow=0;
    boolean foundAll= false;

    public boolean isValid(int i, int j, char[][] board, int n, int m, int target)
    {
        int count=0;
        // check row
        for(int x=0; x<m; x++)
        {
            if((board[i][x]-'0') == target)
                count++;
        }
        if(count>0)
            return false;

        // check column
        for(int x=0; x<n; x++)
        {
            if((board[x][j]-'0') == target)
                count++;
        }
        if(count>0)
            return false;

        int directions[][]= {{0,0}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
        int row, col;
        if(i+1<=3)
        {
            row=1;
            if(j+1<=3)              // first box
                col= 1;
            else if(j+1<=6)         // second box
                col= 4;
            else                    // third box
                col= 7;
        }
        else if(i+1<=6)
        {
            row= 4;
            if(j+1<=3)
                col= 1;
            else if(j+1<=6)
                col= 4;
            else
                col= 7;
        }
        else
        {
            row= 7;
            if(j+1<=3)
                col= 1;
            else if(j+1<=6)
                col= 4;
            else
                col= 7;
        }

        
        for(int dir[]: directions)
        {
            int x= row+dir[0];
            int y= col+dir[1];

            if((board[x][y]-'0') == target)
                count++;
        }
        return count==0;
    }

    public void helper(int row, int col, char board[][], int n, int m)
    {
        if(col==m)
        {
            row++;
            col=0;
        }

        if(row==n)
        {
            foundAll= true;
            return;
        }

        // already filled then check next col
        if(board[row][col]!='.')
        {
            helper(row, col+1, board, n, m);
            return;
        }

        
        // check different values
        for(int val=1; val<=9; val++)
        {
            if(isValid(row, col, board, n, m, val))
            {
                board[row][col]= (char)(val+'0');
                helper(row, col+1, board, n, m);

                if(foundAll)
                    return;
                
                board[row][col]= '.';
            }
        }
    }

    public void solveSudoku(char[][] board) {
        int n= board.length, m= board[0].length;
        helper(0, 0, board, n, m);
    }
}