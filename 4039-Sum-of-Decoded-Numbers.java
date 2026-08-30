class Solution {
    long mod= 1_000_000_000 + 7;
    public int sumDecoded(long[] nums) {
        int n= nums.length, sum=0;

        for(int i=0; i<n; i++)
            {
                int width= (int)(nums[i]%10);
                long di= nums[i]/10;

                int length= (int)Math.log10(di) + 1;
                int ydigits= length-width;
                
                long y=di%10, fact10=10, m= di/10;
                ydigits--;
                
                while(ydigits > 0)
                    {
                        y= (m%10)*fact10 + y;
                        fact10*= 10;
                        ydigits--;
                        m/=10;
                    }
                 
                long x= m;

                long val= modPower(x, y);
                sum= (int) ((sum+val) % mod);
            }
        return sum;
    }
    
    public long modPower(long x, long y)
    {
        long result = 1;
        x %= mod;

        while (y > 0) {
            if ((y & 1) == 1) {
                result = (result * x) % mod;
            }

            x = (x * x) % mod;
            y >>= 1;
        }

        return result;
    }
}