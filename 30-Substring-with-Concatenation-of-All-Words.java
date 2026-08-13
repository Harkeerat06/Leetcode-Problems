class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list= new ArrayList<>();
        HashMap<String, Integer> need= new HashMap<>();

        for(String str: words)
        {
            need.put(str, need.getOrDefault(str,0)+1);
        }

        int n= s.length(), wlen= words[0].length(), arrLen= words.length;

        for(int start= 0; start<wlen; start++)
        {
            HashMap<String, Integer> map= new HashMap<>();
            int i=start, j=start, found=0;

            while(j<n)
            {
                String wrd= "";

                if(j+wlen <= n)
                    wrd= s.substring(j, j+wlen);
                else
                    break;
                
                j+= wlen;

                if(!need.containsKey(wrd))
                {
                    // remove all the words and start fresh from j
                    map.clear();
                    i=j;
                    found=0;
                }
                else
                {
                    // keep removing until the current word count becomes < needed
                    while(map.getOrDefault(wrd,0) >= need.get(wrd))
                    {
                        String remWrd= s.substring(i,i+wlen);
                        map.put(remWrd, map.get(remWrd)-1);
                        
                        found--;
                        i+= wlen;
                    }

                    // increase curr word's freq
                    map.put(wrd, map.getOrDefault(wrd, 0)+1);
                    found++;
                }

                if(found==arrLen)
                {
                    list.add(i);
                }
            }
        }
        return list;
    }
}