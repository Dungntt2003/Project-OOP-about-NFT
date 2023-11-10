package Object;

import java.util.ArrayList;
import java.util.List;

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

	// Phương thức search theo date
	public static void searchByDate(List<NFTs> nftsList, String searchDate) {
        for (NFTs nft : nftsList) {
            if (nft.getDate().equals(searchDate)) {
                System.out.println("Title: " + nft.getTitle());
                System.out.println("Author: " + nft.getAuthor());
                System.out.println("Date: " + nft.getDate());
                System.out.println("Tag: " + nft.getTag());
                System.out.println("------------------------");
            }
        }
    }
}
