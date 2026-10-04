/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        
        if(node.neighbors.size()==0)
            return new Node(node.val);

        boolean visit[]= new boolean[101];
        Node map[]= new Node[101];
        Queue<Node> q= new LinkedList<>();
        q.offer(node);

        Node copy= new Node(node.val);
        Node cloneHead= copy;
        map[node.val]= copy;
        visit[node.val]= true;

        while(!q.isEmpty())
        {
            Node curr= q.poll();
            copy= map[curr.val];

            List<Node> list= curr.neighbors;
            int size= list.size();

            for(int i=0; i<size; i++)
            {
                Node partner= list.get(i);
                Node newNode;

                if(map[partner.val]!=null)
                    newNode= map[partner.val];
                else
                {
                    newNode= new Node(partner.val);
                    map[partner.val]= newNode;
                }

                copy.neighbors.add(newNode);

                if(visit[partner.val])
                    continue;
                visit[partner.val]= true;
                q.offer(partner);
            }
        }
        return cloneHead;
    }
}