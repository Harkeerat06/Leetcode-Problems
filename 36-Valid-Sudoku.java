class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check all 3x3 grids
        int squares[][]= {{1,1}, {1,4}, {1,7}, {4,1}, {4,4}, {4,7}, {7,1}, {7,4}, {7,7}};
        int directions[][]= {{0,0}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};

        for(int arr[]: squares)
        {
            int i= arr[0], j= arr[1];
            int freq[]= new int[10];
            
            for(int dir[]: directions)
            {
                int x= i+ dir[0], y= j+dir[1];

                if(board[x][y]=='.')
                    continue;
                
                int num= board[x][y] - '0';
                if(freq[num]!=0)
                    return false;

                freq[num]++;
            }
        }

        // check all rows
        for(int i=0; i<9; i++)
        {
            int freq[]= new int[10];

            for(int j=0; j<9; j++)
            {
                if(board[i][j]=='.')
                    continue;
                
                int num= board[i][j] - '0';
                if(freq[num]!=0)
                    return false;

                freq[num]++;
            }
        }

        // check all columns
        for(int j=0; j<9; j++)
        {
            int freq[]= new int[10];
            
            for(int i=0; i<9; i++)
            {
                if(board[i][j]=='.')
                    continue;
                
                int num= board[i][j] - '0';
                if(freq[num]!=0)
                    return false;

                freq[num]++;
            }
        }
        return true;
    }
}