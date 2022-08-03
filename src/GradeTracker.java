import java.util.ArrayList;

public class GradeTracker {
    public static void main(String[] args) {

        Module test = new Module("PF", "PF001", "Program", 100);

        ArrayList<Assessment> assessments = new ArrayList<>();

        System.out.println("Before");
        test.getAllAssessments();

        assessments.add(new Assessment("CA1", "Descriptor1" , 100, 10));
        assessments.add(new Assessment("CA2", "Descriptor2" , 100, 20));
        assessments.add(new Assessment("CA3", "Descriptor3" , 100, 30));

        System.out.println("After");
        test.setAssessments(assessments);

        test.getAllAssessments();

        System.out.println();
        test.getAssessment(1);

        assessments.add(new Assessment("CA4", "Des4", 100, 40));

        System.out.println("After");
        test.setAssessments(assessments);

        test.getAllAssessments();


        String name;
        for (int x = 0; x < (assessments.size()); x++) {
            if ((assessments.get(x).getName()).equals(name)) {
                return x;
            }
        }

    }
}

/* Test Code.
Module test = new Module("PF", "PF001", "Program", 100);

        ArrayList<Assessment> assessments = new ArrayList<>();

        System.out.println("Before");
        test.getAllAssessments();

        assessments.add(new Assessment("CA1", "Descriptor1" , 100));
        assessments.add(new Assessment("CA2", "Descriptor2" , 100));
        assessments.add(new Assessment("CA3", "Descriptor3" , 100));

        System.out.println("After");
        test.setAssessments(assessments);

        test.getAllAssessments();

        System.out.println();
        test.getAssessment(1);

 */