import java.util.*;
import java.util.Scanner;
public class BotDictionary {

	public static void main(String[] args) {

		System.out.println("====================================");
		System.out.println("=======Welcome BOT Dictional========");
		System.out.println("====================================");
		System.out.println();

		System.out.println("If You want to exit this process, enter exit keyword");
		System.out.println();

		BotController control = new BotController();
		control.userInput();
	}
}

class Bot {

	private Map<String,String> dictional;
	private String question;

	Bot() {
		dictional = new HashMap<>();
		dictional.put("name","I am MR.BOT");
		question = null;
	}

	public String talk(String message) {

		if(null != question) {
			dictional.put(question,message);
			System.out.println("I got it");
			question = null;
			

			return "Thank for teach me";

		}

		String value = dictional.get(message.toLowerCase());
		if(null != value) {
			return value;
		}

		this.question = message;

		return "Sry!.. I don't know.Please teach me > ";
	}
}

class BotController {

	private Bot bot;
	private Scanner sc;

	BotController() {
		bot = new Bot();
		sc = new Scanner(System.in);
	}

	public void userInput() {

		while(true) {

			System.out.print("YOU > " );
			String message = sc.nextLine();

			if("exit".equalsIgnoreCase(message)) {
				break;
			}

			String result = bot.talk(message);
			System.out.println("BOT :  " + result);
		}

	}
}