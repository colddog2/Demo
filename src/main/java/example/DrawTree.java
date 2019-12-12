package example;

import java.util.LinkedList;
import java.util.Queue;

public class DrawTree {

    /***
     * draw nodes only if the number of all nodes with their level or less is no more than maxToDraw
     * @param root root node
     * @param maxToDraw
     * @return number of nodes drawn for testing purposes
     */
    public static int draw(Node root, int maxToDraw) {
        if (root == null) {
            return 0; //nothing to do
        }

        if (maxToDraw < 1) {
            return 0; //nothing to do
        }

        root.setLevel(0);
        int numberOfSeen = 1;
        int currentLevel = 0;
        int numDrawn = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (numberOfSeen > maxToDraw && current.getLevel() > currentLevel) {
                break;
            }

            currentLevel = current.getLevel();

            current.draw();
            numDrawn++;

            for (Node neighbour: current.getNeighbours()) {
                if (neighbour.getLevel() == null || neighbour.getLevel() > current.getLevel()) {
                    neighbour.setLevel(current.getLevel() + 1);
                    numberOfSeen++;
                    queue.add(neighbour);
                }
            }
        }

        return numDrawn;
    }
}
