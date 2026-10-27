class Solution {
    public String[] createGrid(int m, int n) {
        String arr[]= new String[m];
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<n; i++)
            sb.append('.');

        arr[0]= sb.toString();

        for(int i=1; i<m; i++)
        {
            sb= new StringBuilder();
            for(int j=0; j<n; j++)
            {
                if(j==n-1)
                    sb.append('.');
                else
                    sb.append('#');
            }
            arr[i]= sb.toString();
        }
        return arr;
    }
}