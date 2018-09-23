/**
 * Created with IntelliJ IDEA.
 * User: Konstantin
 * Date: 23.09.18
 * Time: 7:05
 * To change this template use File | Settings | File Templates.
 */
public class Circle {

    private double radius;
    private double reference;
    private double area;
    private static final double PERIMETER_COST=2000;
    private static final double ROAD_COST=1000;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.area = Math.pow(this.radius,2.0)*Math.PI;
        this.reference = 2*Math.PI*this.radius;
    }

    public double getReference() {
        return reference;
    }

    public void setReference(double reference) {
        this.reference = reference;
        this.radius = this.reference/2/Math.PI;
        this.area = Math.pow(this.reference,2)/4/Math.PI;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
        this.radius = Math.sqrt(2*area/Math.PI);
        this.reference = 2*Math.sqrt(area * Math.PI);
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(10.0);
        System.out.println("R="+c.getRadius()+"\nL="+c.getReference()+"\nS="+c.getArea());

        Circle earth = new Circle();
        earth.setRadius(6378.1 * 1000);
        double tmpRadius=earth.getRadius();
        earth.setReference(earth.getReference() + 1);
        double delta=earth.getRadius()-tmpRadius;
        System.out.println();
        System.out.println("Delta="+delta);

        Circle pool = new Circle();
        double poolRadius=3;
        double roadRadius=1;
        System.out.println();
        pool.setRadius(poolRadius+roadRadius);
        double perimeterTotal=pool.getReference()*PERIMETER_COST;
        double tmp_roadTotal=pool.getArea();
        pool.setRadius(poolRadius);
        double roadTotal=tmp_roadTotal-pool.getArea();
        roadTotal*=ROAD_COST;
        System.out.println("perimeterTotal="+perimeterTotal);
        System.out.println("roadTotal="+roadTotal);
    }




}
