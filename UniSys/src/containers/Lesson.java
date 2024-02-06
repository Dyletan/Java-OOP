package containers;

import data.*;
import entities.*;
import messages.*;
import containers.*;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;
/*
* This class is used to represent a lesson
* And it is going to be stored in Schedule class
* */

public class Lesson implements Comparable<Lesson>, Serializable{
    private Time startTime;
    private Time endTime;
    private LessonType lessonType;
    private Cabinet cabinet;
    private WeekDay weekDay;
    private Teacher teacher;
    private Course course;
    private Vector<Student> enrolledStudents;
    {
    	setEnrolledStudents(new Vector<Student>());
    }

    public Lesson() {}

    public Lesson(Time startTime, Time endTime, LessonType lessonType, Cabinet cabinet, WeekDay weekDay, Teacher teacher, Course course) {
        setStartTime(startTime);
        setEndTime(endTime);
        this.lessonType = lessonType;
        this.cabinet = cabinet;
        this.weekDay = weekDay;
        this.teacher = teacher;
        this.course = course;
    }

    @Override
    public String toString() {
        return course.getCourseName() + " " +
                 lessonType +
                " " + startTime +
                "-" + endTime +
                " " + weekDay +
                " " + cabinet +
                " " + teacher.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(startTime, lesson.startTime)
                && Objects.equals(endTime, lesson.endTime)
                && lessonType == lesson.lessonType
                && Objects.equals(cabinet, lesson.cabinet)
                && weekDay == lesson.weekDay
                && Objects.equals(teacher, lesson.teacher)
                && Objects.equals(course, lesson.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime, lessonType, cabinet, weekDay, teacher, course);
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        if (endTime.compareTo(startTime) < 0) {
            throw new IllegalArgumentException("End time must be equal to or after the start time.");
        }
        this.endTime = endTime;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int compareTo(Lesson o) {
        if(weekDay.compareTo(o.weekDay) != 0){
            return weekDay.compareTo(o.weekDay);
        }
        else return startTime.compareTo(o.startTime);
    }

    /**
    * @return Returns a Comparator that sorts based on the day of the week and start time of the lesson
    */
    public static Comparator<Lesson> getLessonComparator() {
        return Comparator.naturalOrder(); // returns Comparator defined by current compareTo()
    }

	public Vector<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(Vector<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
}
