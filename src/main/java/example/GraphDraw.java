package example;/* Simple graph drawing class
Bert Huang
COMS 3137 Data Structures and Algorithms, Spring 2009

This class is really elementary, but lets you draw 
reasonably nice graphs/trees/diagrams. Feel free to 
improve upon it!
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GraphDraw extends JFrame {
    int width;
    int height;

    ArrayList<Node> nodes;
    ArrayList<edge> edges;

    int getIndex(String id) {
        if (nodes == null) return -1;
        for (int i=0; i<nodes.size();i++) {
            if (nodes.get(i).name.equals(id)) {
                return i;
            }
        }

        return -1;
    }

    public GraphDraw() { //Constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nodes = new ArrayList<Node>();
        edges = new ArrayList<edge>();
        width = 30;
        height = 30;
    }

    public GraphDraw(String name) { //Construct with label
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nodes = new ArrayList<Node>();
        edges = new ArrayList<edge>();
        width = 30;
        height = 30;
    }

    class Node {
        int x, y;
        String name;

        public Node(String myName, int myX, int myY) {
            x = myX;
            y = myY;
            name = myName;
        }
    }

    class edge {
        int i,j;

        public edge(int ii, int jj) {
            i = ii;
            j = jj;
        }
    }

    public void addNode(String name, int x, int y) {
        //add a node at pixel (x,y)
        nodes.add(new Node(name,x,y));
        this.repaint();
    }
    public void addEdge(int i, int j) {
        //add an edge between nodes i and j
        edges.add(new edge(i,j));
        this.repaint();
    }

    public void paint(Graphics g) { // draw the nodes and edges
        FontMetrics f = g.getFontMetrics();
        int nodeHeight = Math.max(height, f.getHeight());

        g.setColor(Color.black);
        for (edge e : edges) {
            g.drawLine(nodes.get(e.i).x, nodes.get(e.i).y,
                    nodes.get(e.j).x, nodes.get(e.j).y);
        }

        for (Node n : nodes) {
            int nodeWidth = Math.max(width, f.stringWidth(n.name)+width/2);
            g.setColor(Color.white);
            g.fillOval(n.x-nodeWidth/2, n.y-nodeHeight/2,
                    nodeWidth, nodeHeight);
            g.setColor(Color.black);
            g.drawOval(n.x-nodeWidth/2, n.y-nodeHeight/2,
                    nodeWidth, nodeHeight);

            g.drawString(n.name, n.x-f.stringWidth(n.name)/2,
                    n.y+f.getHeight()/2);
        }
    }
}

class testGraphDraw {
    //Here is some example syntax for the GraphDraw class
    public static void main(String[] args) {
        GraphDraw frame = new GraphDraw("Test Window");

        frame.setSize(1000,1000);

        frame.setVisible(true);

        Node node = buildTDrawableTree(frame);
        DrawTree.draw(node, 20);

    }


    private static Node buildTDrawableTree(GraphDraw graphDraw) {
        int i=1;
        DrawableNode root = new DrawableNode(graphDraw, i++);
        root.setOffset(500);
        root.setLevel(0);

        Node neighbour1 = new DrawableNode(graphDraw, i++);
        Node neighbour2 = new DrawableNode(graphDraw, i++);
        Node neighbour3 = new DrawableNode(graphDraw, i++);

        Node neighbour2_1 = new DrawableNode(graphDraw, i++);
        Node neighbour2_2 = new DrawableNode(graphDraw, i++);

        Node neighbour3_1 = new DrawableNode(graphDraw, i++);
        Node neighbour3_2 = new DrawableNode(graphDraw, i++);
        Node neighbour3_3 = new DrawableNode(graphDraw, i++);

        Node neighbour2_2_1 = new DrawableNode(graphDraw, i++);
        Node neighbour3_2_1 = new DrawableNode(graphDraw, i++);


        root.addNeighbour(neighbour1);
        root.addNeighbour(neighbour2);
        root.addNeighbour(neighbour3);

        neighbour2.addNeighbour(neighbour2_1);
        neighbour2.addNeighbour(neighbour2_2);
        neighbour3.addNeighbour(neighbour3_1);
        neighbour3.addNeighbour(neighbour3_2);
        neighbour3.addNeighbour(neighbour3_3);

        DrawableNode neighbour3_3_1 = new DrawableNode(graphDraw, i++);
        DrawableNode neighbour3_3_2 = new DrawableNode(graphDraw, i++);
        DrawableNode neighbour3_3_3 = new DrawableNode(graphDraw, i++);
        DrawableNode neighbour3_3_4 = new DrawableNode(graphDraw, i++);
        Node neighbour2_2_1_1 = new DrawableNode(graphDraw, i++);
        Node neighbour2_2_1_2 = new DrawableNode(graphDraw, i++);

        DrawableNode neighbour3_3_3_1 = new DrawableNode(graphDraw, i++);
        DrawableNode neighbour3_3_3_2 = new DrawableNode(graphDraw, i++);


        neighbour3_3.addNeighbour(neighbour3_3_1);
        neighbour3_3.addNeighbour(neighbour3_3_2);
        neighbour3_3.addNeighbour(neighbour3_3_3);
        neighbour3_3.addNeighbour(neighbour3_3_4);



        neighbour3_3_3.addNeighbour(neighbour3_3_3_1);
        neighbour3_3_3.addNeighbour(neighbour3_3_3_2);


        neighbour2_2.addNeighbour(neighbour2_2_1);
        neighbour3_2.addNeighbour(neighbour3_2_1);

        neighbour2_2_1.addNeighbour(neighbour2_2_1_1);
        neighbour2_2_1.addNeighbour(neighbour2_2_1_2);


        //cycles
        neighbour1.addNeighbour(root);
        neighbour3.addNeighbour(root);
        neighbour3_3.addNeighbour(neighbour2);
        neighbour3_3.addNeighbour(neighbour1);

        return root;
    }


}