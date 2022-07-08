import java.util.Stack;

public class Node {
    private int node;
    private Node left;
    private Node right;

    public void print() {
        System.out.println(node);
    }
//node
    public int gValue() {return this.node;}
    public void sValue(final int value) {this.node = value;}
//left child
    public Node gLeft() {return this.left;}
    public void sLeft(final Node left) {this.left = left;}
//right child
    public Node gRight() {return this.right;}
    public void sRight(final Node right) {this.right = right;}

    @Override
    public String toString() {return "Node{" + "node=" + node + ", leftChild=" + left + ", rightChild=" + right + '}';}
}



