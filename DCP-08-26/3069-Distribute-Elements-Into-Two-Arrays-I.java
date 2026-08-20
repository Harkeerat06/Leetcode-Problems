class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1= new ArrayList<>();
        List<Integer> list2= new ArrayList<>();

        int idx= 2, n= nums.length, i1=0, i2=0;
        list1.add(nums[0]);
        list2.add(nums[1]);

        while(idx < n)
        {
            if(list1.get(i1) > list2.get(i2))
            {
                list1.add(nums[idx]);
                i1++;
            }
            else
            {
                list2.add(nums[idx]);
                i2++;
            }
            idx++;
        }
        list1.addAll(list2);
        int ans[]= new int[n];

        for(int i=0; i<n; i++)
        {
            ans[i]= list1.get(i);
        }
        return ans;
    }
}