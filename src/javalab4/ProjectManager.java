package javalab4;

public class ProjectManager extends Manager implements Heading {

    private static final double PROJECT_PERCENT = 0.1;
    private Project project;
    private double projectBonus;
    private double headBonus;
    private int subordinatesQty;
    private double subordinatesRate;


    public ProjectManager(Integer id, String name, String position, Double hourlyRate, Integer actualHours) {
        super(id, name, position, hourlyRate, actualHours);
    }

    public double getHeadBonus() {
        // TODO implement here
        return 0;
    }
    @Override
    public double getProjectBonus() {
        projectBonus = ((project == null) ? 0 : project.getBudget()) * PROJECT_PERCENT;
        return projectBonus;

    }
    @Override
    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public Project getProject() {
        return project;
    }
}