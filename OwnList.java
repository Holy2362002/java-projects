 import java.util.Scanner;
 import java.util.Arrays;
 class OwnListDemo<T> {

	private int size = 0;
	// private T capacity = 10;

	@SuppressWarnings("unchecked")
	private T[] element = (T[]) new Object[0];

	// @SuppressWarnings("unchecked")
	// OwnListDemo() {
	// 	element = {};
	// }

	// public void add(T data) {
	// 	element[size] = data;
	// 	size++;

	// } 

	public void add(T data) {
		element = Arrays.copyOf(element,element.length+1);
		element[element.length - 1] = data;
		size++;
	}

	public T get(int index) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("index out of range");
		}

		return element[index];
	}

	public void remove(int index) {

		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index out of range");
		}

		for(int i = index; i < size - 1; i++) {
			element[i] = element[i + 1];
		}

		size--;


	}

	public void set(int index,T value) {

		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index out of range");
		}

		element[index] = value;
	}

	public int size() {
		return size;
	}

		

}

public class OwnList {

	
	static String decision2;
	public static void main(String[] args) {
		
		OwnListDemo<String> demo = new OwnListDemo<>();

		
		Scanner sc = new Scanner(System.in);
		System.out.println("=============================================");
		System.out.println("=========Welcome List data Structure=========");
		System.out.println("=============================================");

		do{
			System.out.print("Enter Your Input Data::::::: ");
			String data = sc.nextLine();
			demo.add(data);

			

			System.out.println("Do you want to add Input againg:::::");
			decision2 = sc.nextLine();


		}while(!"N".equalsIgnoreCase(decision2));

		System.out.print("Do you want to remove data 'Y' or 'No': ");
		String decision =sc.next();

			if("Y".equalsIgnoreCase(decision)) {
				System.out.print("Enter you index that you want to delete: ");
				int index = sc.nextInt();
				sc.nextLine();
				if(index >= demo.size() || index < 0) {
					throw new IndexOutOfBoundsException("Index out of range");					 
				}

				demo.remove(index);
			}

		System.out.print("Do You want to set data:::");
		String decision3 = sc.nextLine();
		if("Y".equalsIgnoreCase(decision3)) {
			String newData = sc.nextLine();
		    int newIndex = sc.nextInt();
		    sc.nextLine();

		    demo.set(newIndex,newData);
		}

		System.out.println("This is the set of list");
		for(int i = 0; i < demo.size() ; i++) {
			System.out.println(demo.get(i));
		}
	}
}
