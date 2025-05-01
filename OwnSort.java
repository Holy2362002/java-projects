public class OwnSort {
	public static void main(String[] args) {
		//SortDemo demo = new SortDemo();

		//demo.doSort();

		ChooseObject<SortDemoDes> des = new ChooseObject<>(new SortDemoDes());
		var value = des.giveObject();

		value.doSort();

		// SortDemoDes des = new SortDemoDes();
		// des.doSort();


	}
}

class ChooseObject<T> {

	private T object;

	ChooseObject(T object) {
		this.object = object;
	}

	public T giveObject() {
		return object;
	}
}

class SortDemo {

	int [] number = {5,2,9,4,3};

	public void doSort() {

		for(int i = 0; i < number.length - 1 ; i++) {
			for(int j = 0; j < number.length - 1 - i; j++) {

				if(number[j] > number[j + 1] ) {
					int temp = number[j];
					number[j] = number[j + 1];
					number[j + 1] = temp;
				}
			}
		}
 
		for(int num : number) {
			System.out.println(num);
		}
	}
}

class SortDemoDes {

	int[] number = {2,6,9,7,6};

	public void doSort() {
		for(int i = 0; i < number.length - 1;i++) {
			for(int j = 0; j < number.length - 1 ; j++) {
				if(number[j] < number[j + 1] ) {
					int temp = number[j];
					number[j] = number[j + 1];
					number[j + 1] = temp;
				}
			}
		}

		for(int num : number) {
			System.out.println(num);
		}
	}
}