package lab1;

public class Person {
	private Gender gender;
	private String name;
	public Person() {
		name = "No name";
	}
	public Person(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public String toString() {
		return name + " is " + gender;
	}
}
