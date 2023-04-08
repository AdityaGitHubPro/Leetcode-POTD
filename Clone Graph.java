Question Link: https://leetcode.com/problems/clone-graph/



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
    HashMap<Node, Node> mp = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (mp.containsKey(node)) return mp.get(node);

        Node newNode = new Node(node.val);
        mp.put(node, newNode);
        
        for (Node nb: node.neighbors) {
            newNode.neighbors.add(cloneGraph(nb));
        }

        return newNode;
    }
}
