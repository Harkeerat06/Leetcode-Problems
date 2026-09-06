class Solution {
    public int countRotations(String s, int k) {
        int n= s.length();
        StringBuilder sb= new StringBuilder(s);
        int count=0;

        for(int i=0; i<n; i++)
        {
            int score=0;
            for(int j=0; j<n-1; j++)
            {
                if(sb.charAt(j)==sb.charAt(j+1))
                    score++;
            }

            if(score==k)
                count++;
            
            char rem= sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(rem);
        }
        return count;
    }
}