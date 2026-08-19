class Solution {
    public int maxNumberOfFamilies(int n, int[][] arr) {
        HashMap<Integer, HashSet<Integer>> map= new HashMap<>();
        int resLen= arr.length;

        for(int i=0; i<resLen; i++)
        {
            int row= arr[i][0];
            int seat= arr[i][1];

            if(!map.containsKey(row))
                map.put(row, new HashSet<Integer>());

            map.get(row).add(seat);
        }

        int groups= 0, visited=0;

        for(int row: map.keySet())
        {
            HashSet<Integer> set= map.get(row);
            int i=2, j=5;
            visited++;

            while(j<=9)
            {
                int x;
                boolean broke= false;
                for(x=i; x<=j; x++)
                {
                    if(set.contains(x))
                    {
                        broke= true;
                        break;
                    }
                }
                if(broke)
                {
                    i= i+2;
                }

                else
                {
                    i= j+1;
                    groups++;
                }
                j=i+3;
            }
        }
        groups+= (n-visited)*2;
        return groups;
    }
}