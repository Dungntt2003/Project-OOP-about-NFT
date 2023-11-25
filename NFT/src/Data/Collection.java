package Data;

import java.util.Comparator;

public class Collection extends NFT{
	private float price;
	private int transaction;
	public static final Comparator<Collection> COMPARATOR_BY_PRICE = new ComparatorByPrice();
	public Collection () {
		
	}
	public Collection(String title, String author, String date, float price, int transaction) {
		super(title, author, date);
		this.price = price;
		this.transaction = transaction;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	public String toString() {
		return super.toString() + " - " + this.price + " - " + this.transaction;
	}
}
