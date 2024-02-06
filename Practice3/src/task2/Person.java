package task2;

public class Person{
	String name;
	String address;
	public Person(){
		
	}
	public Person(String name) {
		this.name = name;
	}
	public Person(String name, String address){
		this.name = name;
		this.address = address;
	}
	public String getaddress() {
		return this.address;
	}
	public String getName() {
		return this.name;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String toString() {
		return getName() + " " + getaddress(); 
	}
}
