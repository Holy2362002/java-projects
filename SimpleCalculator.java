import java.util.Scanner;
public class SimpleCalculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String decision = null;

		System.out.println("=============================================");
		System.out.println("========Welcome to Smimple Calculator========");
		System.out.println("=============================================");

		

		boolean input = false;

		do{

		double num1 = 0;
		
		
		while(!input) {
			try{
			System.out.print("Enter Number one = ");
			 num1 = sc.nextDouble();
			 input = true;
			}catch(Exception e){
			System.out.println("This is not number, Type again ");
			sc.nextLine();
			}
		}

		System.out.println();

		double num2 = 0;
		boolean input2 = false;

		while(!input2) {
			try{
			System.out.print("Enter Number two = ");
			 num2 = sc.nextDouble();
			 input2 = true;
			}catch(Exception e){
			System.out.println("This is not number, Type again ");
			sc.nextLine();
			}
		}

		System.out.println();

		System.out.print("Choose one operator (+) (-) (*) (/)  = ");
		String operator = sc.next();

		System.out.println();

		SimpleCalculator simple = new SimpleCalculator();
		simple.calculator(num1,num2,operator);

		System.out.print("Do you want to type again = ");

		 decision = sc.next();

		}while(!"N".equalsIgnoreCase(decision));

		sc.close();

	}


	void calculator(double num1,double num2,String operator) {

		double result;

		double result1 = num1 + num2;

		double result2 = num1 - num2;

		double result3 = num1 * num2;

		double result4 = num1 / num2;



		switch(operator) {

		case "+" : System.out.println("The sum of number two = " + result1);
		break;
		case "-" : System.out.println("The minus of number two = " + result2);
		break;
		case "*" : System.out.println("The multipulation of number two = " + result3);
		break;
		case "/" : System.out.println("The divided of number two = " + result4);
		break;
	    default : System.out.println("Not Avalable now");

		}
	}

}