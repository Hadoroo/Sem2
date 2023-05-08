package quiz1;


public class Queue {
    Node head;
    Node tail;
    int size;
    
    boolean isEmpty(){
        return head == null && tail == null;
    }

    int getSize(){
        return size;
    }
    
    void enqueue(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            head = tail = newNode;
        }else{
            tail.under = newNode;
            tail = newNode;
        }
        size++;
    }

    int dequeue(){
        int temp;
        temp = head.data;
        head = head.under;
        if (head == null){
            tail = null;
        }
        size--;
        return temp;
    }

    void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.under;
        }
        System.out.println();
    }
}
