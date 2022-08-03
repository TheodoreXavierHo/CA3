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

        int index = getIndexNumber("CA2", assessments);

        System.out.println(" ");
        test.getAssessment(index);


    }

    public static int getIndexNumber(String name, ArrayList<Assessment> assessments) {
        int index = -1;
        for (int x = 0; x < (assessments.size()); x++) {
            if ((assessments.get(x).getName()).equals(name)) {
                index = x;
                break;
            }
        }

        return index;
    }
}
/*.
Have it when running the getIndexNumber to have a check if getIndexNumber is -1;
throw an IllegalArgumentException or ask the user to retype in the name or there is no
user by that name.

if (getIndexNumber(name, assessments) == -1) {
    throw new IllegalArgumentException("There is no user by that name");
    // Or something like this
}
*/



















/* Test Code.
   To be removed after released version 1.0
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