class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        int n1= arr1.length, n2= arr2.length;

        for(int i=0; i<n1; i++)
        {
            boolean found= false;
            for(int j=0; j<n2; j++)
            {
                if(Math.abs(arr1[i]-arr2[j]) <= d)
                {
                    found= true;
                    break;
                }
            }
            if(!found)
                count++;
        }
        return count;
    }
}