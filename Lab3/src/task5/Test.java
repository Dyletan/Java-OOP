package task5;
import practice2.Time;

public class Test {
	public static void main(String args[]) {
		Chocolate chocolates[] = new Chocolate[5];
		
		chocolates[0] = new Chocolate(35, "Twix");
		chocolates[1] = new Chocolate(40, "Snickers");
		chocolates[2] = new Chocolate(55, "Bounty");
		chocolates[3] = new Chocolate(20, "Rakhat");
		chocolates[4] = new Chocolate(35, "Kit Kat");
		for(Chocolate c : chocolates) {
			System.out.println(c);
		}
		System.out.println("-----------------");
//		Sort.quickSort(chocolates);
		Sort.mergeSort(chocolates);
		for(Chocolate c : chocolates) {
			System.out.println(c);
		}
		System.out.println("-----------------");

		Time times[] = new Time[5];
		times[0] = new Time(12, 5, 7);
		times[1] = new Time(23, 59, 2);
		times[2] = new Time(10, 24, 8);
		times[3] = new Time(10, 11, 44);
		times[4] = new Time(4, 30, 0);
		for(Time t : times) {
			System.out.println(t);
		}
		System.out.println("-----------------");

//		Sort.quickSort(times);
		Sort.mergeSort(times);
		for(Time t : times) {
			System.out.println(t);
		}


	}
}
