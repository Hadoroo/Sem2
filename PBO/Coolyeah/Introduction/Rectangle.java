import JavaCollection.queue1;

public class Rectangle {
    double width;
    double height;

    public Rectangle(){
    }
    public double getArea() {
        return this.width * this.height;
    }
    public double getPerimeter () {
            return 2 * (this.width + this.height);
        }
}