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
    private static final double EARTH_RADIUS=6378.1;

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

        System.out.println(perimeterTotal(3.0,1.0));
        System.out.println(roadTotal(3.0,1.0));

;
    }
    public static double delta(double reference_inc){
        Circle earth = new Circle();
        earth.setRadius(EARTH_RADIUS * 1000);
        double tmpRadius=earth.getRadius();
        earth.setReference(earth.getReference() + reference_inc);
        double delta=earth.getRadius()-tmpRadius;
        return delta;

    }
    public static double perimeterTotal (double poolRadius,double roadRadius){
        Circle pool = new Circle();
        pool.setRadius(poolRadius+roadRadius);
        double perimeterTotal=pool.getReference()*PERIMETER_COST;
        pool.setRadius(poolRadius);
        return perimeterTotal;

    }
    public static double roadTotal (double poolRadius,double roadRadius){
        Circle pool = new Circle();
        pool.setRadius(poolRadius+roadRadius);
        double tmp_roadTotal=pool.getArea();
        pool.setRadius(poolRadius);
        double roadTotal=tmp_roadTotal-pool.getArea();
        roadTotal*=ROAD_COST;
        return roadTotal;

    }



}
