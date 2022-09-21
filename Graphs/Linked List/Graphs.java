import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graphs {
    private HashMap<Integer, Node> node = new HashMap<>();

    private Node getNode(int id) {
        return node.get(id);
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.getAdjacent().add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }
    
    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if(visited.contains(source.getId()))
            return false;
        visited.add(source.getId());
        if(source == destination)
            return true;
        for(Node child : source.getAdjacent()) {
            if(hasPathDFS(child, destination, visited))
                return true;
        }
        return false;
    }

    public boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisited = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisited.add(source);
        while(!nextToVisited.isEmpty()) {
            Node node = nextToVisited.remove();
            if(node == destination)
                return true;
            if(visited.contains(node.getId()))
                continue;
            visited.add(node.getId());
            for(Node child : node.getAdjacent()) {
                nextToVisited.add(child);
            }
        }
        return false;
    }
}
