package InnerClass;

public class A {
    // private int y = 20;
    // int x =15;
    void methodA(){
    class B {
        int x = 10;
        void methodB(){
            System.out.println("x = " + x);
            // System.out.println("Hello, saya method di class B");
            // System.out.println("Kelas B ada dalam Kelas A");
            // System.out.println("y = " + y);
            // System.out.println("x di B = " + this.x);
            // System.out.println("x = " + A.this.x);
        }
    }
    B b = new B();
    b.methodB();
    // void methodA(){
    //     B b = new B();
    //     System.out.println("Hello, saya method di class B");
    //     System.out.println("Saya membuat object dari inner class B");
    //     b.methodB();
    // }
    }
}
