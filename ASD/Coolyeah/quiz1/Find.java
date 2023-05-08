package quiz1;

public class Find {
    int[][] graf;
    int start;
    int end;
    int temp;

    boolean canPass;
    boolean[] passed;

    Stack s = new Stack();
    Queue[] q;

    public Find(int[][] graf, int start, int end) {
        this.graf = graf;
        this.start = start;
        this.end = end;
        this.passed = new boolean[graf.length];
        for (int i = 0; i < graf.length; i++) {
            this.passed[i] = false;
        }
        this.q = new Queue[graf.length];
    }

    boolean checkPassed(int data){
        int[] nearby = s.getStack();
        for (int i = 0; i < nearby.length; i++) {
            int temp = nearby[i];
            if (temp == data && passed[temp]){
                return true;
            }
        }
        return false;
    } 
    
    void newQueue(int current){
        if (q[current] == null) {
            q[current] = new Queue();
            for (int i = 0; i < graf.length; i++) {
                if (graf[current][i] == 1 && !checkPassed(i)){
                    q[current].enqueue(i);
                }
            }
        }
    }

    void Pass(){
        passed[start] = true;
        s.push(start);
        
        while (s.peek() != end-1){
            int current = s.peek();
            newQueue(current);
            if (!q[current].isEmpty()){
                int next = q[current].dequeue();
                if(!passed[next]){
                    passed[next] = true;
                    s.push(next);
                }
            }else if (q[current].isEmpty()) {
                s.pop();
            }
        }
        return;
    }

    void print(){
        Stack s2 = new Stack();
        while (!s.isEmpty()){
            s2.push(s.peek());
            s.pop();
        }
        s2.print();
        System.out.print(end);
    }
    
}
