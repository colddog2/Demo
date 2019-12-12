package example;

public class DrawableNode extends Node {

    private final GraphDraw frame;
    private Integer x;

    DrawableNode(GraphDraw frame, int id) {
        super(id);
        this.frame = frame;
        this.x = null;
    }


    @Override
    void addNeighbour(Node neighbour) {
        super.addNeighbour(neighbour);
        DrawableNode asDrawable = (DrawableNode) neighbour;
        int x = (getNeighbours().size() - 2) * 200/(level + 1)  + (this.x == null? 0 : this.x) ;
        asDrawable.setOffset(x);
    }

    void setOffset(Integer offset) {
        if(this.x == null) {
            this.x = offset;
        }
    }


    @Override
    void draw() {
        int y = (getLevel() + 1) * 100;
        frame.addNode(String.valueOf(id), x, y );

        if (parent == null) {
            return;
        }

        int parentIndex = frame.getIndex(String.valueOf(parent.id));
        int thisIndex = frame.getIndex(String.valueOf(id));

        if (parentIndex == -1){
            return;
        }
        frame.addEdge(parentIndex, thisIndex);
    }
}
