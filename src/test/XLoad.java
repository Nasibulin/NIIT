package test;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 03.10.18
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
class A{}
class B extends A{}
class C extends B{}
class D extends C{}
public class XLoad{
    public static void main(String args[]){
        A[] a=new C[1];
        a[0]=new A();
        //Insert Here
    }
}
