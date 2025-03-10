package task4;

import java.util.Date;
import java.util.Objects;
import java.util.Vector;

public class Manager extends Employee{
    private Vector<Employee> team;
    private double bonus;
    
    public Manager() {}
    
    public Manager(String name, double annualSalary, Date hireDate, String nationalInsuranceNumber, double bonus) {
        super(name, annualSalary, hireDate, nationalInsuranceNumber);
        this.setTeam(team);
        this.setBonus(bonus);
    }

    public Manager(String name, double annualSalary, Date hireDate, String nationalInsuranceNumber, Vector<Employee> team, double bonus) {
        super(name, annualSalary, hireDate, nationalInsuranceNumber);
        this.setTeam(team);
        this.setBonus(bonus);
    }

	public Vector<Employee> getTeam() {
		return team;
	}

	public void setTeam(Vector<Employee> team) {
		this.team = team;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

    @Override
    public String toString() {
        return super.toString() + " " + bonus + " team:\n" + team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager) || !super.equals(o)) return false;
        Manager manager = (Manager) o;
        return manager.bonus == bonus &&
                Objects.equals(team, manager.team);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), team, bonus);
    }
    
    public Object clone() throws CloneNotSupportedException {
    	Manager m = (Manager) super.clone();
    	m.bonus = bonus;
        m.team = (Vector<Employee>) team.clone();
        return m;
    }
}
