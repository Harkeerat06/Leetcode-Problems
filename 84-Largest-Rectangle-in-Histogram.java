class Solution {
    public int largestRectangleArea(int[] arr) {
        int n= arr.length;
        int leftSmaller[]= new int[n];
        int rightSmaller[]= new int[n];
        Stack<Integer> stack= new Stack<Integer>();

        for(int i=0; i<n; i++)
        {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()])
            {
                int idx= stack.pop();
                leftSmaller[idx]= i;
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
            leftSmaller[stack.pop()]= n;

        for(int i=n-1; i>=0; i--)
        {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()])
            {
                int idx= stack.pop();
                rightSmaller[idx]= i;
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
            rightSmaller[stack.pop()]= -1;

        int maxArea= 0;

        for(int i=0; i<n; i++)
        {
            int area= arr[i] * (leftSmaller[i] - rightSmaller[i] - 1);
            maxArea= Math.max(area, maxArea);
        }
        return maxArea;
    }
}