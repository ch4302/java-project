package my_project;

public class BSTtest {
    public static void main(String[] args) {
        // [1]
        BST<Integer, Integer> bst1 = new BST<Integer, Integer>(60, 60);
        bst1.put(50, 50);
        bst1.put(70, 70);
        bst1.put(20, 20);
        bst1.put(10, 10);
        bst1.put(45, 45);
        bst1.put(25, 25);
        bst1.put(40, 40);
        bst1.put(30, 30);

        // [2] [3]
        bst1.print();
        System.out.println();

        // [4]
        System.out.println("Searching for 45 yields: " + bst1.get(45));

        // [5]
        bst1.put(45, 99);
        System.out.println("Searching for 45 yields: " + bst1.get(45));

        // [6]
        System.out.println("Min value: " + bst1.min());

        // [7]
        bst1.deleteMin();
        System.out.println("Min value: " + bst1.min());

        // [8]
        bst1.delete(25);
        bst1.delete(35);
        bst1.delete(45);
        bst1.print();
    }
}

