class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack= new Stack<>();
        int score= 0;

        for(int i=0; i<s.length(); i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                stack.push(0);
            }
            else
            {
                int x= stack.pop();
                if(x==0)
                {
                    stack.push(1);
                }
                else
                {
                    int innerSum=x;
                    while(!stack.isEmpty() && stack.peek()!=0)
                    {
                        innerSum+= stack.pop();
                    }
                    stack.pop();
                    innerSum= innerSum*2;
                    stack.push(innerSum);
                }
            }
        }
        while(!stack.isEmpty())
            score+= stack.pop();
        return score;
    }
}