package my_project;

public class BST <Key extends Comparable<Key>, Value> {
    public Node root;
    public Node getRoot() { return root; } // BST ������
    public BST(Key newId, Value newName) {
        root = new Node(newId, newName);
    }
    // get, put, in, deleteMin, delete �޼ҵ带 ����
    // Ž�� ����, get �޼ҵ�
    public Value get(Key k) { return get(root, k); }
    public Value get(Node n, Key k) {
        if (n == null) return null;
        int t = n.getKey().compareTo(k);
        if (t > 0) return get(n.getLeft(), k);
        else if (t < 0) return get(n.getRight(), k);
        else return (Value) n.getValue();
    }
    // ���� / �߰� ����, put �޼ҵ�
    public void put(Key k, Value v) { root = put(root, k, v); }
    public Node put(Node n, Key k, Value v) {
        if (n == null) return new Node(k, v); // ����, �߰� �� ��带 �����ϰ� ����
        int t = n.getKey().compareTo(k);
        if (t > 0) n.setLeft(put(n.getLeft(), k, v)); // if (k < ��� n�� id) ���� ����Ʈ���� ����
        else if (t < 0) n.setRight(put(n.getRight(), k, v)); // if (k > ��� n�� id) ������ ����Ʈ���� ����
        else n.setValue(v); // ��� n�� name�� v�� ����
        return n;
    }
    // �ּڰ� ã��, min �޼ҵ�
    public Key min() {
        if(root == null) return null;
        return (Key) min(root).getKey();
    }
    private Node min(Node n) {
        if(n.getLeft() == null) return n;
        return min(n.getLeft());
    }
    // �ּڰ� ����, deleteMin �޼ҵ�
    public void deleteMin() {
        if (root == null) System.out.println("empty Ʈ��");
        else root = deleteMin(root);
    }
    private Node deleteMin(Node n) {
        if(n.getLeft() == null) return n.getRight(); // if (n�� ���� �ڽ� == null) n�� ������ �ڽ� ����
        n.setLeft(deleteMin(n.getLeft())); // if (n�� ������ �ڽ� != null) n�� ���� �ڽ����� ���ȣ��
        return n;
    }
    // ���� ����, delete �޼ҵ�
    public void delete(Key k) { root = delete(root, k); }
    public Node delete(Node n, Key k) {
        if(n == null) return null;
        int t = n.getKey().compareTo(k);
        if(t > 0) n.setLeft(delete(n.getLeft(), k)); // if(k < ��� n�� id) ���� �ڽ����� �̵�
        else if(t < 0) n.setRight(delete(n.getRight(), k)); // if(k > ��� n�� id) ������ �ڽ����� �̵�
        else { // ������ ��� �߰�
            if(n.getRight() == null) return n.getLeft();
            if(n.getLeft() == null) return n.getRight();
            Node target = n;
            n = min(target.getRight());
            n.setRight(deleteMin(target.getRight()));
            n.setLeft(target.getLeft());
        }
        return n;
    }
    public void print() {
        inorder(root);
    }
    public void inorder(Node n) { // ������ȸ
        if(n != null) {
            inorder(n.getLeft()); // n�� ���� ����Ʈ���� ��ȸ�ϱ� ����
            System.out.print(n.getKey() + " "); // ��� n �湮
            inorder(n.getRight()); // n�� ������ ����Ʈ���� ��ȸ�ϱ� ����
        }
    }
}
