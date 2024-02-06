package lab1;
import java.util.Vector;

public class Course {
	private String name;
	private String description;
	private int numCredits;
	private Vector<Course> prerequisites;
	{
		prerequisites = new Vector<Course>();
	}
	public Course() {
		name = "No name";
		description = "No description";
		numCredits = 0;
	}
	public Course(String name, String description, int numCredits){
		this.name = name;
		this.description = description;
		this.numCredits = numCredits;
	}
	
	
	public void addPrerequisite(Course p) {
		prerequisites.add(p);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String d) {
		description = d;
	}
	public int getCredits() {
		return numCredits;
	}
	public String toString() {
		String result = "";
		for(Course item : prerequisites) {
			result += "\n"+item.getName();
		}
		return getName() + " is a " + getDescription() + " and has " + getCredits() + " credits.\nPrerequisites:" +result;
	}
	
	
}
