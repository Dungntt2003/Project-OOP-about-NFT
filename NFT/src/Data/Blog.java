package Data;

import java.util.Comparator;

public class Blog extends NFT{
	private int view;
	public static final Comparator<Blog> COMPARATOR_BY_VIEW = new ComparatorByView();
	public Blog() {
		
	}
	public Blog(String title, String author, String date, int view) {
		super(title, author, date);
		this.view = view;
	}
	
	public int getView() {
		return view;
	}
	
	public void setView(int view) {
		this.view = view;
	}
	public String toString() {
		return super.toString() + " - " + this.view;
	}
}
