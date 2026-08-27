class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n= s.length();
        int fs[]= new int[26];
        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);
            fs[ch-'a']++;
        }

        StringBuilder sb= new StringBuilder();
        boolean foundGreater= false;

        // append till chars are equal to target
        for(int i=0; i<n; i++)
        {
            char ch= target.charAt(i);
            int idx= ch-'a';
            int init= idx;

            while(idx<26 && fs[idx]<=0)
                idx++;
            
            if(idx==26)
                break;

            char ap= (char)(idx+'a');
            fs[idx]--;
            sb.append(ap);
            if(idx>init)
            {
                foundGreater= true;
                break;
            }
        }
        
        // backtrack till i get a idx where char > target is available
        if(!foundGreater)
        {
            int i=sb.length()-1;
            while(i>=0)
            {
                int idx= sb.charAt(i) - 'a';
                fs[idx]++;
                sb.deleteCharAt(i);
                
                for(int j=idx+1; j<26; j++)
                {
                    // found a greater letter
                    if(fs[j]>0)
                    {
                        // append the letter and break
                        foundGreater= true;
                        char ap= (char)(j+'a');
                        sb.append(ap);
                        fs[j]--;
                        break;
                    }
                }
                if(foundGreater)
                    break;

                i--;
            }
            // still not found greater
            if(!foundGreater)
                return "";
        }

        // add all the remaining chars from smallest to largest
        for(int i=0; i<26; i++)
        {
            while(fs[i]>0)
            {
                char ch= (char)(i+'a');
                sb.append(ch);
                fs[i]--;
            }
        }

        String ans= sb.toString();
        if(ans.compareTo(target) <= 0)
            return "";

        return sb.toString();
    }
}