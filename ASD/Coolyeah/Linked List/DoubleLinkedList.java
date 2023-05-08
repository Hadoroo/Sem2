// public class DoubleLinkedList {
//     NodeDouble kepala;
//     NodeDouble ekor;
//     int size;

//     DoubleLinkedList(){
//         kepala = ekor = null;
//         size = 0;
//     }

//     public void addFirst(NodeDouble nodeBaru){
//         if (size==0){
//             kepala = ekor = nodeBaru;
//         } else {
//             nodeBaru.next = kepala;
//             kepala.prev = nodeBaru;
//             kepala = nodeBaru;
//         }
//     }

//     public void addAfter(int key, NodeDouble nodeBaru){
//         NodeDouble temp = kepala;
//         while (temp != null){
//             if (key == temp.data){
//                 nodeBaru.next = temp.next;
//                 nodeBaru.prev = temp;
//                 temp.next.prev = nodeBaru.next;
//                 temp.next = nodeBaru;
//                 size++;
//                 break;
//             }
//         }
//         size++;
//     }

//     public void print() {
//         NodeDouble temp = kepala;
//         while (temp != null) {
//             System.out.print(temp.data + " <-> ");
//             temp = temp.next;

//         }
//     }

//     public void deleteFirst(){
//         kepala.next.prev = null;
//         kepala = kepala.next;
//     }
// }
