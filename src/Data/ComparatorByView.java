package Data;

import java.util.Comparator;

public class ComparatorByView implements Comparator<Blog>{

	@Override
	public int compare(Blog o1, Blog o2) {
		// TODO Auto-generated method stub
		if (o1.getView() == o2.getView()) {
			return o1.getTitle().compareTo(o2.getTitle());
		}
		return Long.compare(o2.getView(), o1.getView());
	}
	
}
