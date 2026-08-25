class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n= nums.length;
        int freq[]= new int[101];
        for(int i: nums)
            freq[i]= 1;

        int i=1;
        while(k*i<101 && freq[k*i] == 1)
            i++;
        
        return i*k;
    }
}