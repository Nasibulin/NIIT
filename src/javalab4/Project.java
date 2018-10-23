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
    private int budget;
    private List<Engineer> engineers;
    private List<Manager> managers;

    public Project(int id, String title, int budget) {
        this.id = id;
        this.title = title;
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return (title==null)?"":title;
    }

}
