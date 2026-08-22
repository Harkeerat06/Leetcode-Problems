class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0, pro= 1, m=n;

        while(m>0)
        {
            int dig= m%10;
            sum+= dig;
            pro*= dig;
            m/=10;
        }
        sum+= pro;
        return n%sum==0;
    }
}