class Solution {
    public int formGreatest(int n)
    {
        int digits=(int)Math.log10(n) + 1;
        int arr[]= new int[digits];
        int i=0;

        while(n>0)
        {
            arr[i++]= n%10;
            n/=10;
        }
        Arrays.sort(arr);
        n=0;
        
        for(i= digits-1; i>=0; i--)
        {
            n= n*10 + arr[i];
        }
        return n;
    }
    
    public long maximizeSum(int[] nums, int k) {
        long maxSum=0;
        int n = nums.length;
        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            gain[i] = formGreatest(nums[i]) - nums[i];
            maxSum += nums[i];
        }

        Arrays.sort(gain);

        for (int i = n - 1; i >= 0 && k > 0; i--) {
            if (gain[i] > 0) {
                maxSum += gain[i];
                k--;
            }
        }

        return maxSum;
    }
}