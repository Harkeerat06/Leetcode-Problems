class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        Deque<Integer> dq= new ArrayDeque<>();
        dq.offer(0);

        for(int i=1; i<k; i++)
        {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.pollLast();
            dq.offer(i);
        }
        int ans[]= new int[n-k+1];
        ans[0]= nums[dq.peek()];

        int i=0, j=k, idx=1;
        
        while(j<n)
        {
            if(i == dq.peek())
                dq.poll();
            
            while(!dq.isEmpty() && nums[j] >= nums[dq.peekLast()])
                dq.pollLast();
            
            dq.offer(j);
            ans[idx++]= nums[dq.peek()];
            i++;
            j++;
        }
        return ans;
    }
}