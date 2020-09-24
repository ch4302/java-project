package my_project;

public class BST <Key extends Comparable<Key>, Value> {
    public Node root;
    public Node getRoot() { return root; } // BST 생성자
    public BST(Key newId, Value newName) {
        root = new Node(newId, newName);
    }
    // get, put, in, deleteMin, delete 메소드를 선언
    // 탐색 연산, get 메소드
    public Value get(Key k) { return get(root, k); }
    public Value get(Node n, Key k) {
        if (n == null) return null;
        int t = n.getKey().compareTo(k);
        if (t > 0) return get(n.getLeft(), k);
        else if (t < 0) return get(n.getRight(), k);
        else return (Value) n.getValue();
    }
    // 삽입 / 추가 연산, put 메소드
    public void put(Key k, Value v) { root = put(root, k, v); }
    public Node put(Node n, Key k, Value v) {
        if (n == null) return new Node(k, v); // 삽입, 추가 될 노드를 생성하고 리턴
        int t = n.getKey().compareTo(k);
        if (t > 0) n.setLeft(put(n.getLeft(), k, v)); // if (k < 노드 n의 id) 왼쪽 서브트리에 삽입
        else if (t < 0) n.setRight(put(n.getRight(), k, v)); // if (k > 노드 n의 id) 오른쪽 서브트리에 삽입
        else n.setValue(v); // 노드 n의 name을 v로 갱신
        return n;
    }
    // 최솟값 찾기, min 메소드
    public Key min() {
        if(root == null) return null;
        return (Key) min(root).getKey();
    }
    private Node min(Node n) {
        if(n.getLeft() == null) return n;
        return min(n.getLeft());
    }
    // 최솟값 삭제, deleteMin 메소드
    public void deleteMin() {
        if (root == null) System.out.println("empty 트리");
        else root = deleteMin(root);
    }
    private Node deleteMin(Node n) {
        if(n.getLeft() == null) return n.getRight(); // if (n의 왼쪽 자식 == null) n의 오른쪽 자식 리턴
        n.setLeft(deleteMin(n.getLeft())); // if (n의 오른쪽 자식 != null) n의 왼쪽 자식으로 재귀호출
        return n;
    }
    // 삭제 연산, delete 메소드
    public void delete(Key k) { root = delete(root, k); }
    public Node delete(Node n, Key k) {
        if(n == null) return null;
        int t = n.getKey().compareTo(k);
        if(t > 0) n.setLeft(delete(n.getLeft(), k)); // if(k < 노드 n의 id) 왼쪽 자식으로 이동
        else if(t < 0) n.setRight(delete(n.getRight(), k)); // if(k > 노드 n의 id) 오른쪽 자식으로 이동
        else { // 삭제할 노드 발견
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
    public void inorder(Node n) { // 중위순회
        if(n != null) {
            inorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
            System.out.print(n.getKey() + " "); // 노드 n 방문
            inorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
        }
    }
}
