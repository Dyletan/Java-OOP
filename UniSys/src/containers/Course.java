package containers;

import entities.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class Course implements Serializable{
    private String courseCode;
    private String courseName;
    private int credits;
    private Vector<Course> prerequisites;
    private Vector<Student> registeredStudents;
    private Vector<Teacher> availableTeachers;
    private Vector<Lesson> lessons;

    {
        prerequisites = new Vector<Course>();
        registeredStudents = new Vector<Student>();
        availableTeachers = new Vector<Teacher>();
        lessons = new Vector<Lesson>();
    }

    public Course(){}

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public Course(String courseCode, String courseName, int credits, Vector<Course> prerequisites) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.prerequisites = prerequisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credits == course.credits && Objects.equals(courseCode, course.courseCode) && Objects.equals(courseName, course.courseName) && Objects.equals(prerequisites, course.prerequisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName, credits, prerequisites);
    }

    /**
     * @param course A course that is going to be added to prerequisites
     */
    public void addPrerequisite(Course course){
        prerequisites.add(course);
    }

    public void addRegisteredStudent(Student student){
        registeredStudents.add(student);
    }

    public void addAvailableTeacher(Teacher teacher){
        availableTeachers.add(teacher);
    }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Vector<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(Vector<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public Vector<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(Vector<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public Vector<Teacher> getAvailableTeachers() {
        return availableTeachers;
    }

    public void setAvailableTeachers(Vector<Teacher> availableTeachers) {
        this.availableTeachers = availableTeachers;
    }

    public Vector<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Vector<Lesson> lessons) {
        this.lessons = lessons;
    }
    
    public String toString() {
    	return courseName + " " + courseCode + " " + credits;
    }
}
