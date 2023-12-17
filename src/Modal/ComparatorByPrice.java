package Modal;

import java.util.Comparator;

public class ComparatorByPrice implements Comparator<Collection> {

	@Override
	public int compare(Collection o1, Collection o2) {
		// TODO Auto-generated method stub
		if (o1.getPrice() == o2.getPrice()) {
			return o1.getTitle().compareTo(o2.getTitle());
		}
		return Double.compare(o2.getPrice(), o1.getPrice());
	}

}
