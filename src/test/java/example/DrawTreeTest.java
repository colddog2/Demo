package example;

import org.junit.Assert;
import org.junit.Test;

import static example.DrawTree.draw;

public class DrawTreeTest {

    @Test
    public void test() {
        Assert.assertEquals(0, draw(buildTree(), 0));
        Assert.assertEquals(0, draw(null, 100));

        Assert.assertEquals(4, draw(buildTree(), 4));

        System.out.println();
        Assert.assertEquals(1, draw(buildTree(), 1));

        System.out.println();
        Assert.assertEquals(1, draw(buildTree(), 3));

        System.out.println();
        Assert.assertEquals(4, draw(buildTree(), 8));

        System.out.println();
        Assert.assertEquals(9, draw(buildTree(), 9));

        System.out.println();
        Assert.assertEquals(9, draw(buildTree(), 10));

        System.out.println();
        org.junit.Assert.assertEquals(11, draw(buildTree(), 11));
    }

    private static Node buildTree() {
        int i=0;
        Node root = new Node(i++);

        root.setLevel(0);
        Node neighbour1 = new Node(i++);
        Node neighbour2 = new Node(i++);
        Node neighbour3 = new Node(i++);

        Node neighbour2_1 = new Node(i++);
        Node neighbour2_2 = new Node(i++);
        Node neighbour3_1 = new Node(i++);
        Node neighbour3_2 = new Node(i++);
        Node neighbour3_3 = new Node(i++);

        Node neighbour3_2_1 = new Node(i++);
        neighbour3_2.addNeighbour(neighbour3_2_1);

        Node neighbour2_2_1 = new Node(i++);
        neighbour2_2.addNeighbour(neighbour2_2_1);


        neighbour2.addNeighbour(neighbour2_1);
        neighbour2.addNeighbour(neighbour2_2);

        neighbour3.addNeighbour(neighbour3_1);
        neighbour3.addNeighbour(neighbour3_2);
        neighbour3.addNeighbour(neighbour3_3);

        root.addNeighbour(neighbour1);
        root.addNeighbour(neighbour2);
        root.addNeighbour(neighbour3);

        //cycles
        neighbour1.addNeighbour(root);
        neighbour3.addNeighbour(root);
        neighbour3_3.addNeighbour(neighbour2);

        return root;
    }


}