class Solution {
    public String maxSumOfSquares(int n, int sum) {
        StringBuilder sb= new StringBuilder();

        while(n>0)
        {
            int digit= Math.min(sum, 9);
            sb.append(digit);
            n--;
            sum-= digit;
        }
        if(sum>0 || n>0)
            return "";
        
        return sb.toString();
    }
}