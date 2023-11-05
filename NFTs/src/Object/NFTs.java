package Object;

public class NFTs {
	private String title;
	private String author;
	private String date;
	private String tag;
	
	// Phương thức khởi tạo
	public NFTs() {
		
	}
	public NFTs(String title, String author, String date, String tag) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.tag = tag;
	}
	
	// Getter
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getDate() {
		return this.date;
	}
	public String getTag() {
		return this.tag;
	}
}
