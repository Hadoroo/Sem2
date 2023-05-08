package Stack;

public class StackArray {
    int top;
    int[] stack;
    int array_size;

    public StackArray(int array_size){
        this.array_size = array_size;
        stack = new int [array_size];
        top = -1;
    }

    public boolean isEmty(){
        return (top==1);
    }

    public boolean isFull(){
        return (top==array_size);
    }

    public void push(int val){
        if (!isFull()){
            top++;
            stack[top]=val;
        }else{
            System.out.println("Stack penuh, nilai "+val+" gagal masuk");
        }
    }

    public int pop(){
        if(!isEmty()){
            int temp = stack[top];
            top--;
            return temp;
        }else{
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public void print(){
        for (int i = top; i>= 0; i--){
            System.out.println(stack[i]);
        }
    }
}
class RunStackArray{
    public static void main(String[] args) {
        StackArray tumpukanArray = new StackArray(5);
        tumpukanArray.push(100);
        tumpukanArray.push(200);
        tumpukanArray.push(300);
        int ambil = tumpukanArray.pop();
        System.out.println("Terambil: " + ambil);
        tumpukanArray.print();

    }
}
