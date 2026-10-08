class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb= new StringBuilder();
        int n= s.length(), score=0;

        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);

            if(ch==')')
            {
                if(score==1)
                {
                    score--;
                    continue;
                }
                score--;
                sb.append(ch);
            }
            else
            {
                if(score==0)
                {
                    score++;
                    continue;
                }
                score++;
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}