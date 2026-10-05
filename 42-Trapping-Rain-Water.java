class Solution {
    public int trap(int[] arr) {
        int n= arr.length;
        int maxIdx= -1, max= 0;

        for(int i=0; i<n; i++)
        {
            if(arr[i] >= max)
            {
                max= arr[i];
                maxIdx= i;
            }
        }

        if(maxIdx==-1)
            return 0;

        int leftGreater[]= new int[maxIdx+1];
        int rightGreater[]= new int[n];
        Stack<Integer> stack= new Stack<>();

        for(int i=0; i<=maxIdx; i++)
        {
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()])
            {
                int idx= stack.pop();
                leftGreater[idx]= i;
            }
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1; i>=maxIdx; i--)
        {
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()])
            {
                int idx= stack.pop();
                rightGreater[idx]= i;
            }
            stack.push(i);
        }

        int water= 0;

        // collect water from left to right
        for(int i=0; i<maxIdx;)
        {
            if(arr[i]==0)
            {
                i++;
                continue;
            }

            int target= leftGreater[i], j=i+1;
            int height= Math.min(arr[i], arr[target]);

            while(j<target)
            {
                water+= height - arr[j];
                j++;
            }
            i= target;
        }

        // collect water from right to left
        for(int i=n-1; i>maxIdx;)
        {
            if(arr[i]==0)
            {
                i--;
                continue;
            }

            int target= rightGreater[i], j=i-1;
            int height= Math.min(arr[i], arr[target]);

            while(j>target)
            {
                water+= height - arr[j];
                j--;
            }
            i= target;
        }
        return water;
    }
}