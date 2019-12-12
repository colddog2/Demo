package example;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> neighbours = new ArrayList<>();
    Integer level;
    int id;
    Node parent;

    Node(int id) {
        this.id = id;
        this.parent = null;
    }

    void addNeighbour(Node neighbour) {
        if (level != null)
            neighbour.setLevel(level + 1);

        if (neighbour.parent == null)
            neighbour.parent = this;

        neighbours.add(neighbour);
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    void draw() {
        System.out.println("i am node " + id);
    }
}