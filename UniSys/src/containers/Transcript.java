package containers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Transcript implements Serializable{
    private Semester semester;
    private int year;
    Map<Course, Mark> marks;

    {
        marks = new HashMap<Course, Mark>();
    }

    public Transcript() {}

    public Transcript(Semester semester, int year, double gpa, Map<Course, Mark> marks) {
        this.semester = semester;
        this.year = year;
        this.marks = marks;
    }

    public double calculateGpa() {
        double totalGpa = 0;
        int totalCredits = 0;

        for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();

            totalGpa += mark.getGPA() * course.getCredits();
            totalCredits += course.getCredits();
        }

        return totalCredits != 0 ? totalGpa / totalCredits : 0;
    }

    public void addCourses(Iterable<Course> courses) {
        for (Course course : courses) {
            marks.put(course, new Mark());
        }
    }

    public String toString() {
        String result = "Transcript for " + semester + " semester " + year + "\n";
        result += "Total GPA: " + calculateGpa() + "\n";

        for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
            Mark mark = entry.getValue();

            result += entry.getKey().getCourseName() +
                    ": GPA: " + mark.getGPA() +
                    " " + mark.getGrade() +
                    "\n";
        }
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transcript that = (Transcript) o;
        return year == that.year && semester == that.semester && Objects.equals(marks, that.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semester, year, marks);
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Map<Course, Mark> getMarks() {
        return marks;
    }

    public void setMarks(Map<Course, Mark> marks) {
        this.marks = marks;
    }
}
