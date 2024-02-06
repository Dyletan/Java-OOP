package containers;
import java.io.Serializable;
import java.util.TreeSet;

/*
* This schedule is used to represent list of lessons
* That teachers and students have
* It doesn't allow overlapping lessons and checks if
* The course is registered for this student or teacher
* */

public class Schedule implements Serializable{

    private static final long serialVersionUID = 2067579960924465910L;
	private TreeSet<Lesson> lessons;

    {
        // sorts by week and start time of lesson
        lessons = new TreeSet<Lesson>(Lesson.getLessonComparator());
    }
    public Schedule() {}

    /**
     * @param lesson The lesson that you want to add to the Schedule
     * @throws OverlappingLessonException Is thrown if time of this lesson overlaps with any currently existing lesson
     * @throws CourseNotRegisteredException Is thrown if schedule of object to which schedule belongs doesn't have the lesson registered for them
     */
    public void addLesson(Lesson lesson) throws OverlappingLessonException, CourseNotRegisteredException {
        if(!isOverlap(lesson)){
                lessons.add(lesson);
        }
        else throw new OverlappingLessonException("Lessons overlap. Didn't add");
    }

    // checks the lesson for overlap in time with any other lesson in the Schedule
    private boolean isOverlap(Lesson lesson){ // TO DO
        for (Lesson existingLesson : lessons) {
            if (lesson.getWeekDay() == existingLesson.getWeekDay()) {
                if(lesson.getStartTime().compareTo(existingLesson.getEndTime()) <= 0
                        && lesson.getEndTime().compareTo(existingLesson.getStartTime()) >= 0){
                    return true;
                }
            }

            // If the existing lesson's week is greater than the given lesson's week,
            // we can stop searching because the lessons are sorted.
            if (existingLesson.getWeekDay().compareTo(lesson.getWeekDay()) > 0) {
                break;
            }
        }
        return false;
    }

    public TreeSet<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(TreeSet<Lesson> lessons) {
        this.lessons = lessons;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Create header with weekdays
        sb.append(String.format("| %-10s ", "Time"));
        for (WeekDay day : WeekDay.values()) {
            sb.append(String.format("| %-20s ", day));
        }
        sb.append("|\n");

        // Create horizontal line
        sb.append("+------------");
        for (int i = 0; i < WeekDay.values().length; i++) {
            sb.append("+----------------------");
        }
        sb.append("+\n");

        // Create rows for each time slot
        for (Time startTime : Time.values()) {
            sb.append(String.format("| %-10s ", startTime));

            for (WeekDay day : WeekDay.values()) {
                Lesson lesson = findLesson(day, startTime);

                if (lesson != null) {
                    sb.append(String.format("| %-20s ", lesson.toString()));
                } else {
                    sb.append("|                      ");
                }
            }
            sb.append("|\n");
        }

        return sb.toString();
    }

    // Helper method to find a lesson at a specific day and time
    private Lesson findLesson(WeekDay day, Time startTime) {
        for (Lesson lesson : lessons) {
            if (lesson.getWeekDay() == day && lesson.getStartTime() == startTime) {
                return lesson;
            }
        }
        return null;
    }
}
