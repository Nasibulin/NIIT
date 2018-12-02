
public class Rectangle extends Shape {
    public static boolean isPrinted() {
        return true;
    }
    public void getRectangleDescription() {
        System.out.println("Rectangle: "+isPrinted());
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.getShapeDescription();
        r.getRectangleDescription();
    }
}
