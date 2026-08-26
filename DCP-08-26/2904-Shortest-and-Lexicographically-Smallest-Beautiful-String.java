class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n= s.length();
        int i=0, j=0, count1=0;
        String ans= "";
        int minLen= 101;

        while(j<n)
        {   
            while(i<j && s.charAt(i)!='1')
                i++;
            
            if(s.charAt(j) == '1')
                count1++;
            
            while(count1 > k)
            {
                if(s.charAt(i) == '1')
                    count1--;
                i++;
            }

            if(count1 == k)
            {
                String str= s.substring(i, j+1);

                if(j-i+1 < minLen)
                {
                    ans= str;
                    minLen= j-i+1;
                }
                
                else if((j-i+1)==minLen && str.compareTo(ans) < 0)
                {
                    ans= str;
                    minLen= j-i+1;
                }
                if(s.charAt(i)=='1')
                    count1--;
                i++;
            }
            j++;
        }
        return ans;
    }
}