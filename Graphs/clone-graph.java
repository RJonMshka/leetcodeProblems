// LC 133. Clone Graph

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC133 {
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

    private void mapOldToNew(Node oldNode, Node newNode, Map<Node, Node> nodeReference) {
        if(!nodeReference.containsKey(oldNode)) {
            nodeReference.put(oldNode, newNode);
        }
        if(newNode.neighbors.isEmpty()) {
            for(Node neighbor: oldNode.neighbors) {
                if(nodeReference.containsKey(neighbor)) {
                    newNode.neighbors.add(nodeReference.get(neighbor));
                } else {
                    Node newNeighbor = new Node(neighbor.val);
                    this.mapOldToNew(neighbor, newNeighbor, nodeReference);
                    newNode.neighbors.add(newNeighbor);
                }
            }
        }

    }

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        if(node.neighbors == null) {
            return new Node(node.val);
        }

        // maps from old to new
        Map<Node, Node> nodeReference = new HashMap<>();

        Node newRootNode = new Node(node.val);

        this.mapOldToNew(node, newRootNode, nodeReference);

        return newRootNode;
    }
}
