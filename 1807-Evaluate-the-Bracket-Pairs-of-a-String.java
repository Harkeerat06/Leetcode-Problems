class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map= new HashMap<>();

        for(List<String> pair: knowledge)
        {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder sb= new StringBuilder();
        int n= s.length();

        for(int i=0; i<n;)
        {
            char ch= s.charAt(i);

            // evaluate the key
            if(ch=='(')
            {
                int nextStop= s.indexOf(')', i);
                String key= s.substring(i+1, nextStop);

                sb.append(map.getOrDefault(key, "?"));
                i= nextStop+1;
            }

            // get the next '('
            else
            {
                int nextStop= s.indexOf('(', i);
                if(nextStop==-1)    nextStop= s.length();
                
                sb.append(s.substring(i, nextStop));
                i= nextStop;

            }
        }
        return sb.toString();
    }
}