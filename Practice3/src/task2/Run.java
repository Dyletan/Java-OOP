package task2;

import java.util.Scanner;
import java.util.Vector;

public class Run {
	public String enterName(Scanner in){
		System.out.println("Please enter name: ");
		String name = in.nextLine();
		return name;
	}
	public  String enterAddress(Scanner in){
		System.out.println("Please enter address: ");
		String address = in.nextLine();
		return address;
	}
	public  int enterYear(Scanner in){
		System.out.println("Please enter year of eductaion: ");
		int year = in.nextInt();
		return year;
	}
	public  String enterProgram(Scanner in){
		System.out.println("Please enter study Program: ");
		String program = in.nextLine();
		return program;
	}
	public  double enterFee(Scanner in){
		System.out.println("Please enter studying fee: ");
		double fee = in.nextDouble();
		return fee;
	}
	public  double enterPay(Scanner in){
		System.out.println("Please enter pay for work: ");
		double pay = in.nextDouble();
		return pay;
	}
	public  String enterSchool(Scanner in){
		System.out.println("Please enter working school: ");
		String school = in.nextLine();
		return school;
	}

	public void run() {
		
		Scanner in = new Scanner(System.in);
		Vector<Person> people = new Vector<Person>();
		while(true) {
			System.out.println("Who do you want to add: Student(S), Employee (E) or print (P) (Q to quit)");
			String input = in.nextLine();
			if(input.equals("S")) {
				String name = enterName(in);
				String address = enterAddress(in);
				String program = enterProgram(in);
				int year = enterYear(in);
				double fee = enterFee(in);
				people.add(new Student(name, address, year, program, fee));
			} else if(input.equals("E")){
				String name = enterName(in);
				String address = enterAddress(in);
				String school = enterSchool(in);
				in.nextLine();
				double pay = enterPay(in);
				people.add(new Staff(name, address, school, pay));

			} else if(input.equals("P")){
				for(Person p : people) {
					System.out.println(p);
				}
			} else if(input.equals("Q")){
				break;
			} else {
				System.out.println("Invalid input!");
			}
			in.nextLine();
		}
		in.close();

	}
}
