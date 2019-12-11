package example;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> neighbours = new ArrayList<>();
    Integer level;
    int id;

    Node(int id) {
        this.id = id;
    }

    void addNeighbour(Node neighbour) {
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
        System.out.println("i am node "+id);
    }
}