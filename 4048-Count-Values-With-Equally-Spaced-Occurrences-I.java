class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n= nums.length;

        for(int i=0; i<n; i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            
            map.get(nums[i]).add(i);
        }

        int count=0;
        
        for(int i: map.keySet())
            {
                List<Integer> list= map.get(i);
                if(list.size()!=3)
                    continue;

                int i1= list.get(0), i2= list.get(1), i3= list.get(2);

                if(i3-i2 == i2-i1)
                    count++;
            }
        return count;
    }
}