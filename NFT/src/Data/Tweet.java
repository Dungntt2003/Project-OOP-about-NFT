package Data;

import java.util.Comparator;

public class Tweet extends NFT{
	private int like;
	private int share;
	private int comment;
	public static final Comparator<Tweet> COMPARATOR_BY_LIKE = new ComparatorByLike();
	public Tweet() {
		
	}
	public Tweet(String title, String author, String date, int like, int share, int comment) {
		super(title, author, date);
		this.like = like;
		this.share = share;
		this.comment = comment;
	}
	
	public int getLike() {
		return like;
	}
	
	public void setLike(int like) {
		this.like = like;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public String toString() {
		return super.toString() + " - " + this.like + " - " + this.share + " - " + this.comment;
	}
}
