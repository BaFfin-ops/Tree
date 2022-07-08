import java.util.Stack;

public class NodeTree {
    private Node root;

    public NodeTree() {root = null;}

    public Node find(int value) {
        Node curr = root;
        while (curr.gValue() != value) {
            if (value < curr.gValue()) {curr = curr.gLeft();}
            else {curr = curr.gRight();}
            if (curr == null) {return null;}
        }
        return curr;
    }

    public Object insert(int val) {
        Node newN = new Node();
        newN.sValue(val);
        if (root == null) {root = newN;}
        else {
            Node curr = root;
            Node parent;
            while (true) {
                parent = curr;
                if (val == curr.gValue()) {return null;}
                else if (val < curr.gValue()) {
                    curr = curr.gLeft();
                    if (curr == null) {parent.sLeft(newN); return null;}
                }
                else {
                    curr = curr.gRight();
                    if (curr == null) {parent.sRight(newN); return null;}
                }
            }
        }
        return null;
    }

    public boolean delete(int val) {
        Node curr = root;
        Node parent = root;
        boolean iLeft = true;
        while (curr.gValue() != val) {
            parent = curr;
            if (val < curr.gValue()) { iLeft = true; curr = curr.gLeft();}
            else {iLeft = false; curr = curr.gRight();}
            if (curr == null) return false;
        }

        if (curr.gLeft() == null && curr.gRight() == null) {
            if (curr == root) root = null;
            else if (iLeft) parent.sLeft(null);
            else parent.sRight(null);
        }
        else if (curr.gRight() == null) {
            if (curr == root) root = curr.gLeft();
            else if (iLeft) parent.sLeft(curr.gLeft());
            else parent.sRight(curr.gLeft());
        }
        else if (curr.gLeft() == null) {
            if (curr == root) root = curr.gRight();
            else if (iLeft) parent.sLeft(curr.gRight());
            else parent.sRight(curr.gRight());
        }
        else {
            Node heir = receive(curr);
            if (curr == root) root = heir;
            else if (iLeft) parent.sLeft(heir);
            else parent.sRight(heir);
        }
        return true;
    }

    private Node receive(Node node) {
        Node parent = node;
        Node hN = node;
        Node curr = node.gRight();
        while (curr != null) {
            parent = hN;
            hN = curr;
            curr = curr.gLeft();
        }

        if (hN != node.gRight()) {
            parent.sLeft(hN.gRight());
            hN.sRight(node.gRight());
            hN.sLeft(node.gLeft());
        }
        return hN;
    }

    public void printT() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int g = 32;
        boolean iEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (iEmpty == false) {
            Stack localStack = new Stack();
            iEmpty = true;

            for (int j = 0; j < g; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.gValue());
                    localStack.push(temp.gLeft());
                    localStack.push(temp.gRight());
                    if (temp.gLeft() != null ||
                            temp.gRight() != null)
                        iEmpty = false;
                }
                else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < g * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            g /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }
}
