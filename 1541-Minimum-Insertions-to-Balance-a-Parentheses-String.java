class Solution {
    public int minInsertions(String s) {
        int insert=0, n= s.length(), score=0;
        
        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);
            if(ch=='(')
                score++;
            
            else
            {
                int pair= 0;
                if(i==n-1 || s.charAt(i+1)!=')')
                    pair=1;               
                else
                {
                    i++;
                    pair=2;
                }
                
                if(score>0)
                {
                    insert+= pair%2;
                    score--;
                }
                else
                {
                    insert+= pair%2 + 1;
                }
            }
        }
        insert+= score*2;

        return insert;
    }
}