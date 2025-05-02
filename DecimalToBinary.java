import java.util.*;
public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Decimal Number : " );
		int data = sc.nextInt();
		Converter con = new Converter(data);
		con.decimalToBinary();
	}
}

class Converter {

	private int decimal;
	private int num = 0;
	private int [] binary = new int [20];
	

	Converter(int decimal) {
		this.decimal = decimal;
	}

	public void decimalToBinary() {
		while(decimal > 0) {
			int remainder = decimal % 2;
			binary[num] = remainder;
			num++;

			decimal = decimal / 2;
		}

		for(int i = num - 1; i >=0; i--) {

			System.out.print("Binary Number : "binary[i]);
		}
	}
}