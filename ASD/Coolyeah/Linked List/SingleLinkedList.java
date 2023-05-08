public class SingleLinkedList {
    Node kepala;
    Node ekor;
    int size;

    public SingleLinkedList(){
        this.kepala = null;
        this.ekor = null;
    }

    public void add(int nilai){
        Node temp = new Node();
        temp.data = nilai;
        size++;
        addLast(temp);
    }

    public void addFirst(Node nodeBaru){
        if (kepala == null){
            kepala = nodeBaru;
            ekor = nodeBaru;
        } else {
            nodeBaru.pointer = kepala;
            kepala = nodeBaru;
        }
        size++;
    }

    public void addLast (Node nodeBaru){
        if (kepala == null){
            kepala = nodeBaru;
            ekor = nodeBaru;
        } else {
            ekor.pointer = nodeBaru;
            ekor = nodeBaru;
            ekor.pointer = null;
        }
        size++;
    }

    public void addAfter(int key, Node nodeBaru){
        Node temp = kepala;
        while (temp != null){
            if (key == temp.data){
                nodeBaru.pointer = temp.pointer;
                temp.pointer = nodeBaru;
                size++;
                break;
            }
            temp = temp.pointer;
        }
        size++;
    }

    public int get(int index){
        Node temp = kepala;
        if (index<size){
            for (int i = 0; i < index; i++) {
                temp = temp.pointer;
            }
            return temp.data;
        } else {
            return -1;
        }
        
        
    }

    public void print() {
        Node temp = kepala;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.pointer;

        }
    }

    public void deleteFirst(){
        if (kepala != null){
            kepala = kepala.pointer;
        }
        size--;
    }

    public void deleteLast(){
        if (kepala != null){
            Node temp = kepala;
            while(temp.pointer!=ekor){
                temp = temp.pointer;
            }
            ekor = temp;
            ekor.pointer = null;
        } else {
            kepala = ekor = null;
        }
        size--;
    }
}
