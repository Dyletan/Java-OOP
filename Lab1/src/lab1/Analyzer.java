package lab1;

public class Analyzer {
	public static void main(String[] args) {
		Data unit = new Data();
		java.util.Scanner in = new java.util.Scanner(System.in);
        while (true) {
            System.out.print("Enter number (Q to quit): ");
            
            if (in.hasNextInt()) {
                double x = in.nextInt();
                unit.addData(x);
            } else {
                char input = in.next().charAt(0);
                if (input=='Q') {
                	System.out.println("Average: " +  unit.getAverage());
                	System.out.println("Maximum: " + unit.getMaximum());
                    break;
                } else {
                    System.out.println("Invalid input. Enter an integer or 'Q' to quit.");
                }
            }
        }
        in.close();
	}
}
