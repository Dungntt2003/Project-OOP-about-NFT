package Test;

import Object.NFTs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Tạo một số đối tượng NFTs
        NFTs nft1 = new NFTs("Digital Art", "John Doe", "2023-01-01", "Art, NFT");
        NFTs nft2 = new NFTs("Crypto Kitties", "Alice Smith", "2023-01-02", "Collectibles, Cats");
        NFTs nft3 = new NFTs("Blockchain Games", "Bob Johnson", "2023-01-03", "Games, Blockchain");

        // Tạo danh sách đối tượng NFTs
        List<NFTs> nftsList = new ArrayList<>();
        nftsList.add(nft1);
        nftsList.add(nft2);
        nftsList.add(nft3);

        // In thông tin của từng đối tượng NFTs
        for (NFTs nft : nftsList) {
            nft.print();
        }
    }
}
