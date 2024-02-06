package entities;

import containers.*;

import java.io.Serializable;
import java.util.Vector;

public class Faculty implements Serializable, Comparable<Faculty> {
	private static final long serialVersionUID = -3249975911514227583L;
	private FacultyName name;
    private Vector<Course> mandatoryCourses;
    private Vector<Course> availableMajorElectives;
    private Vector<Course> availableMinorElectives;
    {
    	mandatoryCourses = new Vector<Course>();
    	this.availableMajorElectives = new Vector<Course>();
    	this.mandatoryCourses = new Vector<Course>();
    	
    }

    public Faculty(FacultyName name){
        this.name = name;
    }

    public FacultyName getName() {
        return name;
    }

    public void setName(FacultyName name) {
        this.name = name;
    }

	public Vector<Course> getMandatoryCourses() {
		return mandatoryCourses;
	}

	public void setMandatoryCourses(Vector<Course> mandatoryCourses) {
		this.mandatoryCourses = mandatoryCourses;
	}

	public Vector<Course> getAvailableMajorElectives() {
		return availableMajorElectives;
	}

	public void setAvailableMajorElectives(Vector<Course> availableMajorElectives) {
		this.availableMajorElectives = availableMajorElectives;
	}

	public Vector<Course> getAvailableMinorElectives() {
		return availableMinorElectives;
	}

	public void setAvailableMinorElectives(Vector<Course> availableMinorElectives) {
		this.availableMinorElectives = availableMinorElectives;
	}

	@Override
	public int compareTo(Faculty o) {
		return this.name.compareTo(o.name);
	}
	
	public void addMandatoryCourse(Course course) {
        if (mandatoryCourses == null) {
            mandatoryCourses = new Vector<>();
        }
        mandatoryCourses.add(course);
    }

    public void addAvailableMajorElective(Course course) {
        if (availableMajorElectives == null) {
            availableMajorElectives = new Vector<>();
        }
        availableMajorElectives.add(course);
    }

    public void addAvailableMinorElective(Course course) {
        if (availableMinorElectives == null) {
            availableMinorElectives = new Vector<>();
        }
        availableMinorElectives.add(course);
    }

   
}
