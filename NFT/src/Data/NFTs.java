package Data;

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
	
	// Phương thức in thông tin
    public void print() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Date: " + this.date);
        System.out.println("Tag: " + this.tag);
        System.out.println("------------------------");
    }
    
	// Phương thức search theo chuỗi tag/hashtag/keyword/title/author
	public static void searchByString(List<NFTs> nftsList, String keyWord) {
		String key = keyWord.toLowerCase();
        for (NFTs nft : nftsList) {
            if (nft.getTitle().toLowerCase().contains(key) || 
            	nft.getAuthor().toLowerCase().contains(key) || 
            	nft.getTag().toLowerCase().contains(key)) {
            	System.out.println("Title: " + nft.getTitle());
                System.out.println("Author: " + nft.getAuthor());
                System.out.println("Date: " + nft.getDate());
                System.out.println("Tag: " + nft.getTag());
                System.out.println("------------------------");
            }
        }
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
