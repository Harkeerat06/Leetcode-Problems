class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int n= arr.length;
        int closest= arr[0] + arr[1] + arr[2];
        
        for(int i=0; i<n; i++)
        {
            int left= i+1, right= n-1;

            while(left<right)
            {
                int sum= arr[i] + arr[left] + arr[right];
                if(Math.abs(target-sum) < Math.abs(target-closest))
                {
                    closest= sum;
                }

                if(sum > target)
                    right--;
                else if(sum<target)
                    left++;
                else
                    return target;
            }
        }
        return closest;
    }
}