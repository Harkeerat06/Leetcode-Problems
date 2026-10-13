class Solution {
    public long maxAlternatingSum(int[] arr) {
        int n= arr.length;
        if(n==1)
            return arr[0] * arr[0];

        int nums[]= new int[n];
        for(int i=0; i<n; i++)
        {
            nums[i]= Math.abs(arr[i]);
        }

        Arrays.sort(nums);
        int i=0, j= n-1;
        long sum=0;

        

        while(i<j)
        {
            sum-= (nums[i] * nums[i]);
            sum+= (nums[j] * nums[j]);
            i++;
            j--;
        }

        if(n%2!=0)
            sum+= (nums[i] * nums[i]);

        return sum;
    }
}