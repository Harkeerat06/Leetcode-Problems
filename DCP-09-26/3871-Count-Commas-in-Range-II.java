class Solution {
    public long countCommas(long n) {
        if(n<1000)
            return 0;

        // int len= (int)Math.log10(n) + 1;
        int len=4;
        long count=0;

        for(long i=1000; i<=n; i*=10, len++)
        {
            int commas= (len-1)/3;

            if(i*10 > n)
                count+= commas * (n-i+1);
            else
                count+= commas * (i*10 - i);
        }
        return count;
    }
}