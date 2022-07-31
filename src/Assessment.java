public class Assessment {
    private String name; // Name of the Assessment (e.g. CA1, CA2, etc.).
    private String description; // The description of the Module
    private Module module; // A reference to the Module this Assessment belongs to
    private double marks; // The marks scored for this particular Assessment
    private double totalMarks; // Total possible marks for this Assessment
    private double weightage; // The percentage of marks (out of the overall) that this Assessment carries

    public double getWeightedMarks() {
        return this.marks/this.totalMarks;
    }
}
