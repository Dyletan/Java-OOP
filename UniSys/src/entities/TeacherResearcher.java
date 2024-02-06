package entities;

import java.io.Serializable;

public class TeacherResearcher extends Teacher implements Researcher, Serializable{
	public TeacherResearcher() {}

    public TeacherResearcher(String userid, Login login, String email, String name, String surname, TeacherTitle teacherTitle) {
    	super(userid, login, email, name, surname, teacherTitle);
    }
}
