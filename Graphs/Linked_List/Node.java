package Graphs.Linked_List;

import java.util.LinkedList;

public class Node {
    private int id;

    LinkedList<Node> adjacent = new LinkedList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Node> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(LinkedList<Node> adjacent) {
        this.adjacent = adjacent;
    }

}
