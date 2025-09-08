/*************************************************************
 * Program : CollegeClass.java
 * Purpose : This file contains the class definition and implementation
 *           of the CollegeClass. It contains attributes such as CRN, department,
 *           course number, instructional mode, meeting day/time, capacity, enrollment,
 *           and instructor ID
 *
 * Created : 9/7/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

public class CollegeClass {

    // Declare member variables
    private int crn;
    private String department;
    private int courseNumber;
    private String instructionalMode;
    private String meetingDays;
    private String meetingTimes;
    private int capacity;
    private int enrollment;
    private int instructorId;

    // Declare default constructor
    public CollegeClass(){
        this.crn = 0;
        this.department = "";
        this.courseNumber = 0;
        this.instructionalMode = "";
        this.meetingDays = "";
        this.meetingTimes = "";
        this.capacity = 0;
        this.enrollment = 0;
        this.instructorId = 0;
    }

    // Declare a parameterized constructor to receive input
    public CollegeClass(int crn, String department, int courseNumber,
                        String instructionalMode, String meetingDays,
                        String meetingTimes, int capacity,
                        int enrollment, int instructorId) {
        this.crn = crn;
        this.department = department;
        this.courseNumber = courseNumber;
        this.instructionalMode = instructionalMode;
        this.meetingDays = meetingDays;
        this.meetingTimes = meetingTimes;
        this.capacity = capacity;
        this.enrollment = enrollment;
        this.instructorId = instructorId;
    }

    // Declare getters and setters

    public int getCrn() { return crn; }
    public void setCrn(int crn) { this.crn = crn; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getCourseNumber() { return courseNumber; }
    public void setCourseNumber(int courseNumber) { this.courseNumber = courseNumber; }

    public String getInstructionalMode() { return instructionalMode; }
    public void setInstructionalMode(String instructionalMode) { this.instructionalMode = instructionalMode; }

    public String getMeetingDays() { return meetingDays; }
    public void setMeetingDays(String meetingDays) { this.meetingDays = meetingDays; }

    public String getMeetingTimes() { return meetingTimes; }
    public void setMeetingTimes(String meetingTimes) { this.meetingTimes = meetingTimes; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getEnrollment() { return enrollment; }
    public void setEnrollment(int enrollment) { this.enrollment = enrollment; }

    public int getInstructorId() { return instructorId; }
    public void setInstructorId(int instructorId) { this.instructorId = instructorId; }

    // Declare a toString() method to return a string containing all attributes
    public String toString() {
        return "CRN : " + crn + "\n" +
                "Department : " + department + "\n" +
                "Course number : " + courseNumber + "\n" +
                "Instructional mode : " + instructionalMode + "\n" +
                "Meeting days : " + meetingDays + "\n" +
                "Meeting times : " + meetingTimes + "\n" +
                "Capacity : " + capacity + "\n" +
                "Enrollment : " + enrollment + "\n" +
                "Instructor’s ID : " + instructorId;
    }
}
