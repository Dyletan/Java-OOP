package task2;

public class Staff extends Person{
	String school;
	double pay;
	public Staff() {

	}
	public Staff(String name, String address, String school, double pay) {
		super(name, address);
		this.school = school;
		this.pay = pay;
	}
	public String getSchool() {
		return this.school;
	}
	public double getPay() {
		return this.pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String toString() {
		return super.toString() + " " + getPay() + " " + getSchool();
	}

}
