class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n= arr.length;
        List<List<Integer>> list= new ArrayList<>();

        for(int i=0; i<n-3; i++)
        {
            if(i>0 && arr[i]==arr[i-1])
                continue;

            for(int j=i+1; j<n-2; j++)
            {
                if(j>i+1 && arr[j]==arr[j-1])
                    continue;
                
                long ntarget= target - (0L + arr[i]+arr[j]);
                int left= j+1, right= n-1;

                while(left<right)
                {
                    long sum= 0L + arr[left] + arr[right];

                    if(sum == ntarget)
                    {
                        list.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        
                        while(left<right && arr[left]==arr[left+1])
                            left++;
                        
                        while(left<right && arr[right]==arr[right-1])
                            right--;
                        
                        left++;
                        right--;
                    }
                    else if(sum < ntarget)
                        left++;
                    else
                        right--;
                }
            }
        }
        return list;
    }
}