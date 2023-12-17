package Modal;

import java.util.ArrayList;
import java.util.Comparator;

public class Blog extends NFT {
	private long view;
	public static final Comparator<Blog> COMPARATOR_BY_VIEW = new ComparatorByView();

	public Blog() {

	}

	public Blog(String title, String author, String date, ArrayList<String> tag, long view) {
		super(title, author, date, tag);
		this.view = view;
	}

	public long getView() {
		return view;
	}

	public void setView(long view) {
		this.view = view;
	}

	public String toString() {
		return super.toString() + " - " + this.view;
	}
}
