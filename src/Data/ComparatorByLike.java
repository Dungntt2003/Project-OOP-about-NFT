package Data;

import java.util.Comparator;

public class ComparatorByLike implements Comparator<Tweet>{
	@Override
	public int compare(Tweet o1, Tweet o2) {
		// TODO Auto-generated method stub
		if (o1.getLike() == o2.getLike()) {
			return o1.getTitle().compareTo(o2.getTitle());
		}
		return Long.compare(o2.getLike(), o1.getLike());
	}
}


