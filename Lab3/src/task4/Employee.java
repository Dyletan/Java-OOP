package task4;

import java.util.Date;
import java.util.Objects;

public class Employee extends Person implements Comparable<Employee>, Cloneable{
	private double annualSalary;
	private Date hireDate;
	private String nationalInsuranceNumber;

	public Employee() {}
	public Employee(String name, double annualSalary, Date hireDate, String nationalInsuranceNumber) {
		super(name);
		this.setAnnualSalary(annualSalary);
		this.setHireDate(hireDate);
		this.setNationalInsuranceNumber(nationalInsuranceNumber);
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getNationalInsuranceNumber() {
		return nationalInsuranceNumber;
	}

	public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
		this.nationalInsuranceNumber = nationalInsuranceNumber;
	}

	public String toString() {
		return super.toString() + " " + annualSalary + " " + hireDate + " " + nationalInsuranceNumber;
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || !(this instanceof Employee) || !(super.equals(o))) return false;
		Employee other = (Employee) o;
		return other.annualSalary == annualSalary &&
				hireDate.equals(other.hireDate) &&
				nationalInsuranceNumber.equals(other.nationalInsuranceNumber);
	}

	public int hashCode() {
		return Objects.hash(getName(), annualSalary, hireDate, nationalInsuranceNumber);
	}

	@Override
	public int compareTo(Employee o) {
		if(annualSalary != o.annualSalary) {
			if(annualSalary > o.annualSalary) return 1;
			return -1;
		}
		if(this instanceof Manager && o instanceof Manager) {
			if(((Manager)this).getBonus() > ((Manager)o).getBonus()) {
				return 1;
			}
			if(((Manager)this).getBonus() < ((Manager)o).getBonus()) {
				return -1;
			}
		}
		return 0;
	}

	public Object clone() throws CloneNotSupportedException {
		Employee e = (Employee) super.clone();
		e.hireDate = (Date)hireDate.clone();
		return e;
	}
}
