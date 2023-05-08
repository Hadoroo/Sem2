public class Circle {
    //** The radius of this circle
    double radius = 1;
     //** Return the area of this circle
    double getArea() {
        return radius * radius * Math.PI;
    }
    //** Return the perimeter of this circle
    double getPerimeter () {
        return 2 * radius * Math.PI;
    }
    //** Set new radius for this circle
    void setRadius (double newRadius){
        radius = newRadius;
    }
}