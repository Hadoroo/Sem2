import java.util.Scanner;

import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.InputEvent;

class Node {
    String data;
    Node next;
    
    public Node (String input){
        next = null;
        this.data = input;
    }

    public Node(){

    }
}

class SLL {
    Node head;
    Node tail;
    int size;
    
  
    boolean isEmpty() {
        return head == null && tail == null;
    }

    int getSize() {
        System.out.println(size);
        return size;
    }
  
    void addLast(String input) {
        Node newNode = new Node(input);
        if (head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
  
      void addFirst(String input) {
        Node newNode = new Node(input);
        if (head == null){
            head = tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
          size++;
    }
  
      void printList() {
        Node temp = head;
          while (head != null){
              System.out.print(temp.data + " ");
              temp = temp.next;
          }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SLL sll = new SLL();

        int n = sc.nextInt(); // jumlah loop/input yg mau dimasukkan
        sc.nextLine(); // consume new line, tanya chatGPT aja kalo gatau

        String command = ""; // -> digunakan untuk input, misal : "MAKAN JAGUNG"
        String[] splitted = new String[2]; // -> split dari command, akan berisi [MAKAN, JAGUNG]
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            splitted = command.split(" ");

            if (splitted[0].toLowerCase().equals("addfirst")) {
                sll.addFirst(data);
            } else if (splitted[0].toLowerCase().equals("addlast")) {
                sll.addLast(command);
            } else if (splitted[0].toLowerCase().equals("print")) {
                /* 
                KATA MASBRO KERJAIN DISINI
                */
            } else if (splitted[0].toLowerCase().equals("remove")) {
                if (splitted[1].toLowerCase().equals("last")) {
                      /* 
                    KATA MASBRO KERJAIN DISINI
                    */
                } else if (splitted[1].toLowerCase().equals("first")) {
                      /* 
                    KATA MASBRO KERJAIN DISINI
                    */
                }
            }
        }
    }
}
