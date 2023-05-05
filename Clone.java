//Time = O(N+E), where N is the number of nodes and E is the number of edges in the input graph
//Space = O(N+E)

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
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>(); // map to store cloned nodes
        Queue<Node> queue = new LinkedList<>(); // queue for BFS
        
        Node clone = new Node(node.val); // create a clone of the starting node
        map.put(node, clone); // add the original and cloned nodes to the map
        queue.add(node); // add the original node to the queue
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll(); // get the next node from the queue
            
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) { // if the neighbor hasn't been cloned yet
                    Node cloneNeighbor = new Node(neighbor.val); // create a clone of the neighbor
                    map.put(neighbor, cloneNeighbor); // add the original and cloned nodes to the map
                    queue.add(neighbor); // add the original neighbor to the queue
                }
                
                map.get(curr).neighbors.add(map.get(neighbor)); // add the cloned neighbor to the cloned current node's neighbors list
            }
        }
        
        return clone; // return the cloned starting node
    }
}
