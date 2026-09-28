class Solution {
    public int maxDepth(String s) {
        int n= s.length();
        int nested=0, count=0;

        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);
            if(ch=='(')
            {
                count++;
                nested= Math.max(nested, count);
            }
            else if(ch==')')
            {
                count--;
            }
        }
        return nested;
    }
}