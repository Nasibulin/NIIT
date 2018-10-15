package test;

import java.util.Date;

class SuperClass {
    static void printMe(){
        System.out.print("super context ");
        }
    }
        public class SubClass extends SuperClass {
    public static void printMe()throws ArithmeticException{
        System.out.print("sub context ");
        }
    public static void main(String argv[]){
        Date d = new Date(1000);
        d.toString();
        }
    }
