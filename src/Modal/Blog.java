package Modal;

import java.util.ArrayList;

public class Blog extends NFT {
	private String title;
	private long view;

	public Blog() {

	}

	public Blog(String title, String author, String date, ArrayList<String> tag, long view) {
		super(author, date, tag);
		this.view = view;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
