package task1;
public class Example1
{
	public static void main(String[] args)
	{
		int     denominator, numerator, ratio;

		numerator   = 5;
		denominator = 0;

		try{
			ratio = numerator / denominator;
			System.out.println("The answer is: "+ratio);
		} catch(ArithmeticException e) {
			System.out.println("Cannot divide by 0. Ending program");
			e.printStackTrace();
		}
		System.out.println("Done."); // Don't move this line

	}
}
