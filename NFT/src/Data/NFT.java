package Data;

import java.util.ArrayList;

public class NFT {
	private String title;
	private String author;
	private String date;
	private ArrayList<String> tag = new ArrayList<String>();
	
	public NFT() {
		
	}
	public NFT(String title, String author, String date) {
		this.title = title;
		this.author = author;
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getDate() {
		return date;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTag(ArrayList<String> tag) {
		this.tag = tag;
	}
	public ArrayList<String> getTag() {
		return tag;
	}
	public void addTag(String hashtag) {
		tag.add(hashtag);
	}
	public String printTag() {
		String s = "";
		for (String hashtag : tag) {
			s += hashtag + " ";
		}
		return s;
	}
	public String toString() {
		return this.title + " - " + this.author + " - " + this.date + "- " + printTag();
	}
}
