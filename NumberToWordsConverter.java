import java.util.Scanner;
public class NumberToWordsConverter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		NumWords con = new NumWords();
		System.out.print("Enter Your Number : ");
		int num = sc.nextInt();
		String words = con.toConverter(num);
		System.out.println("In words : " + words);
	}
}

class NumWords {

	// private final static String [] belowTwinty = {" ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
    //         "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    // private final static String [] tens = {" ", " ", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    // private final static String [] thousand = {" ", "thousand", "million", "billion"};

    // 1 to 19
		private static final String[] belowTwenty = {
		    "", "တစ်", "နှစ်", "သုံး", "လေး", "ငါး", "ခြောက်", "ခုနစ်", "ရှစ်", "ကိုး", "ဆယ်",
		    "ဆယ့်တစ်", "ဆယ့်နှစ်", "ဆယ့်သုံး", "ဆယ့်လေး", "ဆယ့်ငါး", "ဆယ့်ခြောက်", "ဆယ့်ခုနစ်", "ဆယ့်ရှစ်", "ဆယ့်ကိုး"
		};

		// Tens (20, 30, 40, ...)
		private static final String[] tens = {
		    "", "", "နှစ်ဆယ်", "သုံးဆယ်", "လေးဆယ်", "ငါးဆယ်", "ခြောက်ဆယ်", "ခုနစ်ဆယ်", "ရှစ်ဆယ်", "ကိုးဆယ်"
		};

		// Scales (thousand, million, etc.)
		private static final String[] thousand = {
		    "", "ထောင်", "သိန်း", "သန်း"
		};


    public static String toConverter(int num) {
    	if(num == 0) {
    		return "zero";
    	}

    	int i = 0;
    	String word = " ";

    	while(num > 0) {
    		if(num % 1000 != 0) {
    		   word = converter(num % 1000) + "," + thousand[i] + word;
    		}

    		num /= 1000;
    		i++;
    	}

    	return word.trim();
    }


    public static String converter(int num) {

    	if(num == 0) {
    		return " ";
    	}else if(num < 20) {
    		return belowTwinty[num ]+ " ";
    	}else if(num < 100) {
    		return tens[num / 10] + "  " + converter(num % 10);
    	}else {
    		return belowTwinty[num / 100] + "hundred" + converter(num % 100);
    	}


    }


}

