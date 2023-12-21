package Modal;

import java.util.ArrayList;
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

}
