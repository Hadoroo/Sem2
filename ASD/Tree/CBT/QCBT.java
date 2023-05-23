package CBT;

import java.util.NoSuchElementException;

public class QCBT {
    NodeCBT front;
    NodeCBT rear;
    int size;

    boolean isEmpty(){
        return front == null && rear == null;
    }

    void enqueue(int data) {
        NodeCBT newNode = new NodeCBT(data); // Create a new NodeCBT object with the given data
        
        if (isEmpty()) {
            // If the queue is empty, set the front and rear to the new node
            front = rear = newNode;
        } else {
            rear.right = newNode; // Link the current rear node to the new node
            newNode.left = rear; // Set the previous rear as the left child of the new node
            rear = newNode; // Update the rear to the new node
        }
        size++;
    }

    void enqueue(NodeCBT data) {
        if (isEmpty()) {
            // If the queue is empty, set the front and rear to the new node
            front = rear = data;
        } else {
            rear.right = data; // Link the current rear node to the new node
            data.left = rear; // Set the previous rear as the left child of the new node
            rear = data; // Update the rear to the new node
        }
        size++;
    }

    NodeCBT dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        
        NodeCBT dequeuedNode = front;  // Store the front node to be dequeued
        
        if (front == rear) {
            // If there is only one node in the queue
            front = rear = null;
        } else {
            front = front.right;  // Move the front pointer to the next node
            front.left = null;    // Remove the link to the dequeued node
        }
        
        size--;
        return dequeuedNode;
    }
}