package Data;

import java.util.ArrayList;
import java.util.Comparator;

public class Collection extends NFT{
	private double price;
	private long transaction;
	public static final Comparator<Collection> COMPARATOR_BY_PRICE = new ComparatorByPrice();
	public Collection () {
		
	}
	public Collection(String title, String author, String date,ArrayList<String> tag, double price, long transaction) {
		super(title, author, date, tag);
		this.price = price;
		this.transaction = transaction;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public void setTransaction(long transaction) {
		this.transaction = transaction;
	}
	public String toString() {
		return super.toString() + " - " + this.price + " - " + this.transaction;
	}
}
