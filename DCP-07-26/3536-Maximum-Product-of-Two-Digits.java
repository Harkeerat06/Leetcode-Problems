class Solution {
    public int maxProduct(int n) {
        int max= Math.max(n%10, (n/10)%10), max2= Math.min(n%10, (n/10)%10);
        n/= 100;

        while(n!=0)
        {
            int dig= n%10;

            if(dig>max && dig>max2)
            {
                max2= max;
                max= dig;
            }
            else if(dig>max2)
                max2= dig;
            
            n/=10;
        }
        return max*max2;
    }
}