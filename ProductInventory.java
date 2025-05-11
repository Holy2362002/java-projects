import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
public class ProductInventory {
	public static Scanner sc;

	public static void main(String[] args) {
		ProductManager pm = new ProductManager();
		sc = new Scanner(System.in);
		int chose;
		//String delName;
		pm.showMenu();

		do{
			
            
			System.out.print("Enter choice: ");
            chose = sc.nextInt();
            // if(chose == 9) {
            // 	System.out.print("Delete Product : ");
            // 	delName = sc.nextLine();
            // }

            switch(chose) {
            case 1 -> pm.toFindMaxPrice();
            case 2 -> pm.toSearchWithName("Coke");
            case 3 -> pm.sortProduct();
            case 4 -> pm.listProductAbovePrice(1099.9);
            case 5 -> pm.addToFile("product.txt");
            case 6 -> pm.readToFile("productStore.txt");
            case 7 -> pm.listAllFile();
            case 0 -> System.out.println("Exiting");
            case 8 -> pm.showAddProduct();
            case 9 -> {
            	sc.nextLine();
            	System.out.print("Delete Product Name::");
            	String delName = sc.nextLine();
            	pm.deleteProduct(delName);
            }
            case 10 -> {
            	sc.nextLine();
            	System.out.print("Update Product Name::");
            	String uptName = sc.nextLine();
            	System.out.print("Update Price::");
            	double uptPrice = sc.nextDouble();
            	
            	pm.updatePrice(uptName,uptPrice);
            }
            case 11 -> {
            	sc.nextLine();
            	System.out.print("Update Product Name::");
            	String name = sc.nextLine();            
            	System.out.print("Update Price::");
            	int quantity = sc.nextInt();
            	pm.updateQuantity(name,quantity);
            }
            case 12 -> pm.showMenu();
            default -> System.out.println("Invalid choice");
            }
		}while(chose != 0);
	}
}

class Product {

    private String name;
    private double price;
    private int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
    	this.price = price;
    }

    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("P { %s, %.2f, %d }", name, price, quantity);
    }
}

class ProductManager {
	ProductInventory pi = new ProductInventory();

	private List<Product> products;

	ProductManager() {
		products = new ArrayList<>(List.of(

			new Product("Coke", 1499.99, 100),
            new Product("Water", 599.9, 200),
            new Product("Cake", 2000.6, 65),
            new Product("Potato", 900.99, 150)

		));
	}

	public void showMenu() {
			System.out.println("\n===== Product Inventory Menu =====");
            System.out.println("1. Find Max Price Product");
            System.out.println("2. Search Product By Name");
            System.out.println("3. sorted by Price");
            System.out.println("4. Show Product with limit Price");
            System.out.println("5. Save Products to File");
            System.out.println("6. Load Products from File");
            System.out.println("7. List All Products");
            System.out.println("8. Add Product");
            System.out.println("9. Delete Product");
            System.out.println("10.UpdatePrice");
            System.out.println("11.Update Quantity");
            System.out.println("12.Show Menu");
            System.out.println("0. Exit");
		}

	public void toFindMaxPrice() {
		products.stream().max(Comparator.comparing(Product::getPrice))
		.ifPresentOrElse(
			a -> System.out.println("Found" + a),

			() -> System.out.println("NOt Found")
		);
	}

	public void sortProduct() {
		products.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(System.out::println);
	}

	public void listProductAbovePrice(double limit) {
		products.stream().filter(a -> a.getPrice() >= limit).forEach(System.out::println);
	}

	public void listAllFile() {
		System.out.println("All Products");
		products.stream().forEach(System.out::println);
	}

	public void toSearchWithName(String name) {
		products.stream().filter(a -> a.getName().equalsIgnoreCase(name)).findFirst().
		ifPresentOrElse(
			a-> System.out.println("Found : " + a),
			() -> System.out.println("Not Found")
		);
	}


	public void addProduct(String name,double price,int quantity) {
		Product newProduct = new Product(name,price,quantity);
		products.add(newProduct);
	}

	public void deleteProduct(String name) {
		var type = products.removeIf(a -> a.getName().equalsIgnoreCase(name));
		if(type) {
			System.out.println("Delete Product : ");
		}else{
			System.out.println("Not Found Product");
		}

	}

	public void updatePrice(String name,double price) {
		products.stream().filter(a -> a.getName().equalsIgnoreCase(name)).findFirst()
		.ifPresentOrElse(
			b -> {b.setPrice(price);
			System.out.println("Updated price of " + name + " to " + price);
		},
			() -> System.out.println("not found")
		);
	}

	public void updateQuantity(String name,int quantity) {
		products.stream().filter(a -> a.getName().equalsIgnoreCase(name)).findFirst()
		.ifPresentOrElse(
			a -> {
				a.setQuantity(quantity);
				System.out.println("Updated quantity of " + name + " to " + quantity);
			},
			() -> System.out.println("Not Found Product")
		);
	}

	public void showAddProduct() {
		pi.sc.nextLine();
		System.out.print("Product Name::");
		String name = pi.sc.nextLine();
		//pi.sc.nextLine();
		System.out.print("Product Price::");
		double price = pi.sc.nextDouble();
		//pi.sc.nextLine();
		System.out.print("Enter quantity::");
		int quantity = pi.sc.nextInt();
		addProduct(name,price,quantity);
	}

	public void addToFile(String fileName) {

		try{
			List<String> lines = products.stream().
			map(p -> String.format("%s,%.2f,%d",p.getName(),p.getPrice(),p.getQuantity())).toList();

			Files.write(Path.of(fileName), lines);
			System.out.println(fileName);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void readToFile(String fileName) {
		try{
			List<String> data = Files.readAllLines(Path.of(fileName));

			products = data.stream().map(
				a -> {
					String[] parts = a.split(",");
					return new Product(parts[0],Double.parseDouble(parts[1]),Integer.parseInt(parts[2]));
				}).collect(Collectors.toList());
			System.out.println("Products loaded from " + fileName);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}