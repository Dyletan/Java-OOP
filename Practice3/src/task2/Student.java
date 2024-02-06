package task2;

public class Student extends Person {
	int year;
	String program;
	double fee;
	public Student() {
		super();
		fee = 2000;
	}
	public Student(String name, String address, int year, String program, double fee) {
		super(name, address);
		this.program = program;
		this.fee = fee;
		this.year = year;
	}
	public int getYear() {
		return this.year;
	}
	public String getProgram() {
		return this.program;
	}
	public double getFee() {
		return this.fee;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String toString() {
		return super.toString() + " " + getYear() + " " + getProgram() + " " + getFee();
	}

}
