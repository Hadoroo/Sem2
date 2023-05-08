package quiz1;

public class Stack {
    int datTemp;
    Node top;
    int size;
    
    boolean isEmpty(){
        return top == null;
    }
    
    void makeEmpty(){
        top = null;
        size = 0;
    }
    
    void push(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            top = newNode;
        }else{
            newNode.under = top;
            top = newNode;
        }
        size++;
    }
    
    int peek(){
        return (isEmpty())? null : top.data;
    }
    
    int pop(){
        if(isEmpty()){
            return 0;
        }else{
            datTemp = top.data;
            top = top.under;
            size--;
            return datTemp;
        }
    }
    
    void print(){
        Node temp = top;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.under;
        }
    }

    int[] getStack(){
        int[] stack = new int[size];
        int current = 0;
        for (Node temp = top; temp != null; temp = temp.under) {
            stack[current++] = temp.data;
        }
        return stack;
    }
}
