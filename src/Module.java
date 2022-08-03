import java.util.ArrayList;

public class Module {
    private String name; // Name of the Module
    private String moduleCode; // The module code of the Module
    private String description; // The description of the Module
    private int creditUnits; // How many credits the Module carries
    // A list of Assessments that the module uses to determine the final grade of the student (e.g. CA1, CA2, CA3 etc.)
    private ArrayList<Assessment> assessments = new ArrayList<>();

    public Module(String name, String moduleCode, String description, int creditUnits) {
        this.name = name;
        this.moduleCode = moduleCode;
        this.description = description;
        this.creditUnits = creditUnits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditUnits() {
        return creditUnits;
    }

    public void setCreditUnits(int creditUnits) {
        this.creditUnits = creditUnits;
    }

    // Totals the marks scored across all Assessments.
    public double getOverallMarks() {
        int overallMarks = 0;
        for (Assessment assessment : this.assessments) {
            overallMarks += assessment.getMarks();
        }
        return overallMarks;
    }

    public double getOverallTotalMarks() {
        int overallTotalMarks = 0;
        for (Assessment assessment : this.assessments) {
            overallTotalMarks += assessment.getTotalMarks();
        }
        return overallTotalMarks;
    }

    public String getOverallGrade() {

    }

    public void setAssessments(ArrayList<Assessment> assessments) {
        this.assessments = assessments;
    }

    public void getAllAssessments() {
        this.assessments.forEach(assessment -> {
            System.out.println(assessment.getName() + " - " + assessment.getDescription()
                    + " - " + assessment.getTotalMarks());
        });
    }

    public void getAssessment(int index) {
        System.out.printf("%s - %s - %.1f%n", this.assessments.get(index).getName(),
                this.assessments.get(index).getDescription(),
                this.assessments.get(index).getTotalMarks());
    }
}

/* Test Code.
    public static void main(String[] args) {
        Module test = new Module("TestModule", "D927", "Des1", 12);

        test.assessments.add(new Assessment("CA1", "Descriptor1" , 100));
        test.assessments.add(new Assessment("CA2", "Descriptor2" , 200));
        test.assessments.add(new Assessment("CA3", "Descriptor3" , 300));

        test.assessments.get(0).setMarks(10);
        test.assessments.get(1).setMarks(10);
        test.assessments.get(2).setMarks(10);

        System.out.println(test.assessments.size());

        System.out.println();
        System.out.printf("%.0f%n", test.getOverallMarks());
        System.out.println();

        System.out.println(test.assessments.get(0).getName());
        System.out.println(test.assessments.get(1).getName());
        System.out.println(test.assessments.get(2).getName());

        test.assessments.get(0).setMarks(10);
        System.out.println(test.assessments.get(0).getMarks());

        System.out.println();

        System.out.println(test.assessments.get(0).getDescription());
        System.out.println(test.assessments.get(1).getDescription());
        System.out.println(test.assessments.get(2).getDescription());

        System.out.println();

        System.out.println(test.assessments.get(0).getTotalMarks());
        System.out.println(test.assessments.get(1).getTotalMarks());
        System.out.println(test.assessments.get(2).getTotalMarks());

        System.out.println();

        test.assessments.forEach(assessment -> {
            System.out.println(assessment.getName() + " - " + assessment.getDescription()
                    + " - " + assessment.getTotalMarks());
        });
    }
 */