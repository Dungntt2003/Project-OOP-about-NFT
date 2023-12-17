package Modal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NFTsList {
	private List<NFT> list = new ArrayList<NFT>();

	public void addNFT(NFT a) {
		list.add(a);
	}

	public void printList() {
		for (NFT a : list) {
			System.out.println(a.toString());
		}
	}

	public void searchString(String s) {
		String newS = s.toLowerCase();
		for (NFT a : list) {
			if (a.getDate().contains(newS) || a.getTitle().toLowerCase().contains(newS)
					|| a.getAuthor().toLowerCase().contains(newS) || a.getTag().contains(newS)) {
				System.out.println(a.toString());
			}
		}
	}

//	public void SortByPrice() {
//		ArrayList<Collection> listCollections = new ArrayList<Collection>();
//		for (NFT a : list) {
//			listCollections.add((Collection) a);
//		}
//		Collections.sort(listCollections, Collection.COMPARATOR_BY_PRICE);
//		for (Collection collection : listCollections) {
//			System.out.println(collection.toString());
//		}
//	}

	public void SortByLike() {
		ArrayList<Tweet> listTweets = new ArrayList<Tweet>();
		for (NFT a : list) {
			listTweets.add((Tweet) a);
		}
		Collections.sort(listTweets, Tweet.COMPARATOR_BY_LIKE);
		for (Tweet tweet : listTweets) {
			System.out.println(tweet.toString());
		}
	}

	public void SortByView() {
		ArrayList<Blog> listBlogs = new ArrayList<Blog>();
		for (NFT a : list) {
			listBlogs.add((Blog) a);
		}
		Collections.sort(listBlogs, Blog.COMPARATOR_BY_VIEW);
		for (Blog blog : listBlogs) {
			System.out.println(blog.toString());
		}
	}

}
