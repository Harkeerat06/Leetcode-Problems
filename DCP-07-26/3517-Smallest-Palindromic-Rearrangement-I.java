class Solution {
    public String smallestPalindrome(String s) {
        int len= s.length();
        int mid= len/2;
        int freq[]= new int[26];

        for(int i=0; i<mid; i++)
        {
            freq[s.charAt(i)-'a']++;
        }

        StringBuilder sb= new StringBuilder();

        for(int i=0; i<26; i++)
        {
            while(freq[i]>0)
            {
                char ch= (char)(i+'a');
                sb.append(ch);
                freq[i]--;
            }
        }

        int i= sb.length()-1;
        if(len%2!=0)
            sb.append(s.charAt(mid));
        
        while(i>=0)
        {
            sb.append(sb.charAt(i));
            i--;
        }
        return sb.toString();
    }
}