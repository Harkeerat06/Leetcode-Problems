class Solution {
    public StringBuilder convertToBinary(int n)
    {
        StringBuilder bin= new StringBuilder();
        while(n>0)
        {
            int dig= n%2; 
            bin.append(dig);
            n/=2;
        }
        int len= bin.length();
        while(len<8)
        {
            bin.append(0);
            len++;
        }

        return bin.reverse();
    }

    public boolean isPalindromic(String s) {
        int n= s.length();
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<n; i++)
        {
            int num= s.charAt(i);
            sb.append(convertToBinary(num));
        }

        int i=0, j= sb.length()-1;
        while(i<j)
        {
            if(sb.charAt(i) != sb.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}