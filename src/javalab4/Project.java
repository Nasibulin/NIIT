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
    private List<Engineer> engineers;
    private List<Manager> managers;

    public Project(int id, String title, double budget) {
        this.id = id;
        this.title = title;
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public String toString() {
        return title;
    }

}
