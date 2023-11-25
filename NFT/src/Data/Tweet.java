package Data;

import java.util.Comparator;
import java.util.List;

public class Tweet extends NFTs{
    private int like;
    private int share;
    private int comment;
    
    // Phương thức khởi tạo
    public Tweet() {
    	
    }
    
    public Tweet(int like, int share, int comment) {
        this.like = like;
        this.share = share;
        this.comment = comment;
    }

    // Getter
    public int getLike() {
	     return this.like;
    }

    public int getShare() {
		return this.share;
	}

	public int getComment() {
		return this.comment;
	}
	
	// Phương thức in thông tin của Tweet
	public void printTweet() {
		System.out.println("Like: " + this.like);
        System.out.println("Share: " + this.share);
        System.out.println("Comment: " + this.comment);
        System.out.println("---------------------");
	}

	// Phương thức sắp xếp theo số lượt like
	public static void sortByLike(List<Tweet> tweets) {
		// Sắp xếp theo số lượt like thứ tự tăng dần
		tweets.sort(Comparator.comparingInt(Tweet::getLike));
		
		// Sắp xếp theo số lượt like thứ tự giảm dần
		// tweets.sort(Comparator.comparingInt(Tweet::getLike).reversed());
		
		// In trình tự đã sắp xếp
		for (Tweet tweet : tweets) {
			tweet.printTweet();
		}
	}

	// Phương thức sắp xếp theo số lượt share
	public static void sortByShare(List<Tweet> tweets) {
		// Sắp xếp theo số lượt share thứ tự tăng dần
		tweets.sort(Comparator.comparingInt(Tweet::getShare));
		
		// Sắp xếp theo số lượt share thứ tự giảm dần
		// tweets.sort(Comparator.comparingInt(Tweet::getShare).reversed());
		
		// In trình tự đã sắp xếp
		for (Tweet tweet : tweets) {
			tweet.printTweet();
		}
	}
	
	// Phương thức sắp xếp theo số lượt comment
	public static void sortByComment(List<Tweet> tweets) {
		// Sắp xếp theo số lượt comment thứ tự tăng dần
		tweets.sort(Comparator.comparingInt(Tweet::getComment));
		
		// Sắp xếp theo số lượt comment thứ tự giảm dần
		// tweets.sort(Comparator.comparingInt(Tweet::getComment).reversed());
		
		// In trình tự đã sắp xếp
		for (Tweet tweet : tweets) {
			tweet.printTweet();
		}
	}
	
}
