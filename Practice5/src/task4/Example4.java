package task4;
import java.util.*;

public class Example4
{
	public static void main(String[] args)
	{
		double                 leftOperand, result, rightOperand;
		String                 leftString, operator, rightString;
		StringTokenizer        tokenizer;
		StringTokenizer        spaceTokenizer;
		Scanner in = new Scanner(System.in);

		spaceTokenizer = new StringTokenizer(in.nextLine(), " ");
		int i = -1;

		while(spaceTokenizer.hasMoreTokens()) {
			try
			{
				tokenizer = new StringTokenizer(spaceTokenizer.nextToken(), "+-/*", true);
				leftString   = tokenizer.nextToken();
				operator     = tokenizer.nextToken();
				rightString  = tokenizer.nextToken();
				i++;

				try {
					leftOperand  = Double.parseDouble(leftString);
				} catch (NumberFormatException nfe) {
					System.out.println("Left operand is not a number");
					continue;
				}

				try {
					rightOperand = Double.parseDouble(rightString);
				} catch (NumberFormatException nfe) {
					System.out.println("Right operand is not a number");
					continue;
				}
				
				switch(operator) {
				case "+":
					result = leftOperand + rightOperand;
					break;
				case "-":
					result = leftOperand - rightOperand;
					break;
				case "*":
					result = leftOperand * rightOperand;
					break;
				case "/":
					result = leftOperand / rightOperand;
					break;
				default:
					result = 0.0;
				}

				System.out.println("Result of " + i +"-th attempt: "  + result);
			}

			catch (NoSuchElementException nsee)
			{
				System.out.println("Invalid syntax");
			}
		}
		in.close();
	}
}




