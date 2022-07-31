public class Assessment {
    private String name; // Name of the Assessment (e.g. CA1, CA2, etc.).
    private String description; // The description of the Module
    private Module module; // A reference to the Module this Assessment belongs to
    private double marks; // The marks scored for this particular Assessment
    private double totalMarks; // Total possible marks for this Assessment
    private double weightage; // The percentage of marks (out of the overall) that this Assessment carries

    public Assessment(String name, String description, double totalMarks) {
        this.name = name;
        this.description = description;
        this.totalMarks = totalMarks;
    }
    public double getWeightedMarks() {
        return this.marks/this.totalMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getWeightage() {
        return weightage;
    }

    public void setWeightage(double weightage) {
        this.weightage = weightage;
    }
}
