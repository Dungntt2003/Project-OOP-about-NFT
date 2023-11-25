package Data;

import java.util.Comparator;
import java.util.List;

public class Collection {
	private float price;
	private int transaction;
    
    // Phương thức khởi tạo
    public Collection() {
    	
    }
    
    public Collection(float price, int transaction) {
        this.price = price;
        this.transaction = transaction;
    }

    // Getter
	public float getPrice() {
		return this.price;
	}

	public int getTransaction() {
		return this.transaction;
	}

	// Phương thức in thông tin Collection
	public void printCollection() {
		System.out.println("Price: " + this.price);
		System.out.println("Transaction: " + this.transaction);
        System.out.println("---------------------");
	}

	// Phương thức sắp xếp theo giá của NFTs
	public static void sortByPrice(List<Collection> collections) {
		// Sắp xếp theo giá của NFTs thứ tự tăng dần
		collections.sort(Comparator.comparingDouble(Collection::getPrice));
		
		// Sắp xếp theo giá của NFTs thứ tự giảm dần
		// collections.sort(Comparator.comparingDouble(Collection::getPrice).reversed());
		
		// In trình tự đã sắp xếp
		for (Collection collection : collections) {
			collection.printCollection();
		}
	}
	
	// Phương thức sắp xếp theo giá của NFTs
	public static void sortByTransaction(List<Collection> collections) {
		// Sắp xếp theo lượt giao dịch của NFTs thứ tự tăng dần
		collections.sort(Comparator.comparingInt(Collection::getTransaction));
		
		// Sắp xếp theo lượt giao dịch của NFTs thứ tự giảm dần
		// collections.sort(Comparator.comparingInt(Collection::getTransaction).reversed());
		
		// In trình tự đã sắp xếp
		for (Collection collection : collections) {
			collection.printCollection();
		}
	}
		
}
