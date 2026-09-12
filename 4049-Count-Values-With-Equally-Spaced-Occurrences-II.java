class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> prevGap= new HashMap<>();
        HashSet<Integer> set= new HashSet<>();
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
                int lsize= list.size();

                if(lsize < 3)
                    continue;

                int prev= list.get(1)-list.get(0);
                boolean broke= false;
                
                for(int j= 2; j<lsize; j++)
                {
                    if(list.get(j) - list.get(j-1) != prev)
                        broke= true;
                }
                if(!broke)
                        count++;
            }
        return count;
    }
}