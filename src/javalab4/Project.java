package javalab4;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 19.10.18
 * Time: 8:35
 * To change this template use File | Settings | File Templates.
 */
public class Project {
    private int id;
    private String title;
    private double budget;
    private double engineersRatio;
    private double managersRatio;
    private List<? extends Engineer> engineers;
    private List<? extends Manager> managers;
}