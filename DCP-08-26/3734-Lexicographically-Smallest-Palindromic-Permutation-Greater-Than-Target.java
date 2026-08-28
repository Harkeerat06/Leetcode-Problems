class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n= s.length();

        char oddChar= ' ';
        char oddCount=0;
        int freq[]= new int[26];

        for(int i=0; i<n; i++)
        {
            int idx= s.charAt(i)-'a';
            freq[idx]++;
        }

        for(int i=0; i<26; i++)
        {
            if(freq[i]%2 == 1)
            {
                oddCount++;
                oddChar= (char)(i+'a');
            }
            freq[i]/= 2;
        }

        // length is even but some freq is odd or vice versa
        if((n%2!=0 && oddCount==0) || (n%2==0 && oddCount==1) ||  oddCount>1)
        {
            return "";
        }


        StringBuilder sb= new StringBuilder();
        boolean strictlyGreater= true;

        for(int i=0; i<n/2; i++)
        {
            int idx= target.charAt(i) - 'a';
            int init= idx;

            // get smallest available character
            while(idx<26 && freq[idx] == 0)
                idx++;
            
            // cannot make any strictlyGreater
            if(idx==26)
            {
                strictlyGreater= false;
                break;
            }
            
            char ap= (char)(idx+'a');
            sb.append(ap);
            freq[idx]--;

            if(!canLaterStrictlyGreater(target, freq, oddChar, sb))
            {
                strictlyGreater= false;
                break;
            }

            if(idx>init)
            {
                strictlyGreater= true;
                break;
            }
        }

        StringBuilder sb1= new StringBuilder(sb);
        String s1= sb1.toString();
        if(oddChar != ' ')
            s1= s1+ oddChar + sb1.reverse().toString();
        else
            s1= s1 + sb1.reverse().toString();
        
        if(s1.compareTo(target) <= 0)
            strictlyGreater= false;

        // keep removing letters until 
        if(!strictlyGreater)
        {
            int i=sb.length()-1;
            while(i>=0)
            {
                int idx= sb.charAt(i) - 'a';
                freq[idx]++;
                sb.deleteCharAt(i);
                
                for(int j=idx+1; j<26; j++)
                {
                    // found a greater letter
                    if(freq[j]>0)
                    {
                        // append the letter and break
                        strictlyGreater= true;
                        char ap= (char)(j+'a');
                        sb.append(ap);
                        freq[j]--;
                        break;
                    }
                }
                if(strictlyGreater)
                    break;

                i--;
            }
            // still not found greater
            if(!strictlyGreater)
                return "";
        }

        // add all the remaining chars from smallest to largest
        for(int i=0; i<26; i++)
        {
            while(freq[i]>0)
            {
                char ch= (char)(i+'a');
                sb.append(ch);
                freq[i]--;
            }
        }
        
        
        String ans= sb.toString();
        if(oddChar != ' ')
            ans= ans+ oddChar + sb.reverse().toString();
        else
            ans= ans + sb.reverse().toString();

        return ans;
    }

    public boolean canLaterStrictlyGreater(String target, int freq[], char oddChar, StringBuilder sb2)
    {
        StringBuilder sb= new StringBuilder(sb2);
        int f[]= Arrays.copyOf(freq, 26);

        for(int i=25; i>=0; i--)
        {
            while(f[i]>0)
            {
                char ch= (char)(i+'a');
                sb.append(ch);
                f[i]--;
            }
        }

        String s= sb.toString();
        if(oddChar != ' ')
            s= s+ oddChar + sb.reverse().toString();
        else
            s= s + sb.reverse().toString();

        return s.compareTo(target)>0;
    }
}