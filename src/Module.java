import java.util.ArrayList;

public class Module {
    private String name; // Name of the Module
    private String moduleCode; // The module code of the Module
    private String description; // The description of the Module
    private int creditUnits; // How many credits the Module carries

    // A list of Assessments that the module uses to determine the final grade of the student (e.g. CA1, CA2, CA3 etc.)
    private ArrayList<Assessment> assessments;

    public void listTest() {
        for (int x = 0; x <= assessments.size(); x++) {
            System.out.println(assessments.get(x));
        }
    }

    public static void main(String[] args) {
        Module test = new Module();
        test.listTest();
    }
}
