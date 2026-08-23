class Solution {
    public int longestSubarray(int[] nums, int k) {
        int max= -1, n= nums.length;
        for(int i: nums)
            max= Math.max(i, max);
        
        int spf[]= new int[max+1];
        for(int i=2; i<=max; i++)
        {
            if(spf[i]!=0)
                continue;

            // if spf[i]==0, means the number has been marked and is prime
            for(int j= i; j<=max; j+=i)
            {
                spf[j]= i;
            }
        }

        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            int num= nums[i];
            List<Integer> primeFactors= new ArrayList<>();

            while(num>1)
            {
                primeFactors.add(spf[num]);
                num/= spf[num];
            }
            list.add(primeFactors);
        }

        int i=0, j=0, maxLen=0;
        HashMap<Integer, Integer> map= new HashMap<>();

        while(j<n)
        {
            // add all prime factors of jth number
            for(int x: list.get(j))
            {
                map.put(x, map.getOrDefault(x, 0)+1);
            }

            if(map.size()>k)
            {
                // decrease freq of all prime factors of ith number
                for(int x: list.get(i))
                {
                    int freq= map.get(x);
                    if(freq==1)
                        map.remove(x);
                    else
                        map.put(x, freq-1);
                }
                i++;
            }
            maxLen= Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}