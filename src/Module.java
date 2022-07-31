import java.util.ArrayList;

public class Module {
    private String name; // Name of the Module
    private String moduleCode; // The module code of the Module
    private String description; // The description of the Module
    private int creditUnits; // How many credits the Module carries
    // A list of Assessments that the module uses to determine the final grade of the student (e.g. CA1, CA2, CA3 etc.)
    private ArrayList<Assessment> assessments = new ArrayList<>();


    public static void main(String[] args) {
        Module test = new Module();
        test.assessments.add(new Assessment("CA1", "Grade" , 120));
        test.assessments.add(new Assessment("CA2", "Grad3" , 122130));
        test.assessments.add(new Assessment("CA3", "Graded" , 1212));



        //System.out.println(test.assessments);
        test.assessments.forEach(assessment -> {
            System.out.println(assessment.getName() + " - " + assessment.getDescription()
                    + " - " + assessment.getTotalMarks());
        });
    }
}
