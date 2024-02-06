package entities;

import java.io.Serializable;

public class EmployeeResearcher extends Employee implements Researcher{
	public EmployeeResearcher() {

    }

    public EmployeeResearcher(String userId, Login login, String email, String name, String surname) {
        super(userId, login, email, name, surname);
    }
}
