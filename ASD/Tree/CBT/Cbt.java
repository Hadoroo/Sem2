package CBT;

import java.util.Scanner;

public class Cbt {
    NodeCBT root;
    int size;

    boolean isEmpty(){
        return root == null;
    }

    void insert(int data){
        if (isEmpty()) {
            // If the tree is empty, create a new root node with the given data
            root = new NodeCBT(data);
            size++;
        } else {
            QCBT queue = new QCBT();
            queue.enqueue(root); // Enqueue the root node

            while (!queue.isEmpty()) {
                NodeCBT currentNode = queue.dequeue(); // Dequeue a node from the queue

                // Check if the left child of the current node is empty
                if (currentNode.left == null) {
                    currentNode.left = new NodeCBT(data); // Create a new node with the given data
                    size++;
                    break;
                } else {
                    queue.enqueue(currentNode.left); // Enqueue the left child node
                }

                // Check if the right child of the current node is empty
                if (currentNode.right == null) {
                    currentNode.right = new NodeCBT(data); // Create a new node with the given data
                    size++;
                    break;
                } else {
                    queue.enqueue(currentNode.right); // Enqueue the right child node
                }
            }
        }
    }

    void printPreOrder(NodeCBT temp) {
        System.out.println(temp.data + " ");
        if (temp.left != null) {
            printPreOrder(temp.left);
        }
        if (temp.right != null) {
            printPreOrder(temp.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Cbt c = new Cbt();
        for (int i = 1; i <= n; i++) {
            c.insert(i);
        }
        c.printPreOrder(c.root);
    }


}
