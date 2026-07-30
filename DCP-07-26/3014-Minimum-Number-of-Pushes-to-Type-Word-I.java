class Solution {
    public int minimumPushes(String word) {
        int n= word.length();
        int letterAlotted[]= new int[8];
        int freq[]= new int[26];

        for(int i=0; i<n; i++)
        {
            freq[word.charAt(i)-'a']++;
        }

        Arrays.sort(freq);
        for (int i = 0, j = 7; i<j; i++, j--) 
        {
            int temp = freq[i];
            freq[i] = freq[j];
            freq[j] = temp;
        }
        
        int push= 0;

        for(int i=0; i<26; i++)
        {
            if(freq[i] == 0)
                continue;
            
            int minIdx= 0;
            for(int j=1; j<8; j++)
            {
                if(letterAlotted[j] < letterAlotted[minIdx])
                    minIdx= j;
            }
            letterAlotted[minIdx]++;
            push+= letterAlotted[minIdx] * freq[i];
        }
        return push;
    }
}