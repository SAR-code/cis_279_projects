/*************************************************************
 * Program : Main.java
 * Purpose : Demonstrates the use of the CollegeClass through the
 *           Main.java driver program. Displays the output of each
 *           object created.
 *
 * Created : 9/7/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

public class Main {
    public static void main(String[] args) {
        // Create a new object using the default constructor
        CollegeClass sectionOne = new CollegeClass();

        // Utilize the setters to assign new values to the object
        sectionOne.setCrn(20008);
        sectionOne.setDepartment("CIS");
        sectionOne.setCourseNumber(131);
        sectionOne.setInstructionalMode("Online");
        sectionOne.setMeetingDays("N/A");
        sectionOne.setMeetingTimes("N/A");
        sectionOne.setCapacity(30);
        sectionOne.setEnrollment(30);
        sectionOne.setInstructorId(666);

        // Display the newly created object with the toString() method
        System.out.println("Section One Information:");
        System.out.println(sectionOne.toString());

        // Create a separate object to demonstrate using parameters
        CollegeClass sectionTwo = new CollegeClass(20009, "CIS", 279,
                "Online", "Mon/Wed", "1600",
                40, 32, 777);

        // Display section two with the toString() method
        System.out.println("\nSection Two Information:");
        System.out.println(sectionTwo.toString());
    }
}