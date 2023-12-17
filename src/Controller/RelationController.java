package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Modal.Blog;
import Modal.NFT;
import Modal.Tweet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

//import javafx.scene.text.Text;

public class RelationController implements Initializable {

	@FXML
	private TableView<NFT> tableNFTs;

	@FXML
	private TableColumn<NFT, String> titleColumn;

	@FXML
	private TableColumn<NFT, String> authorColumn;

	@FXML
	private TableColumn<NFT, String> dateColumn;

	@FXML
	private TableColumn<NFT, String> tagColumn;

	@FXML
	private TableView<Tweet> tableTweets;

	@FXML
	private TableColumn<Tweet, String> titleColumn1;

	@FXML
	private TableColumn<Tweet, String> authorColumn1;

	@FXML
	private TableColumn<Tweet, String> dateColumn1;

	@FXML
	private TextField keywordTextField;

	@FXML
	private TableColumn<Tweet, String> tagColumn1;

	@FXML
	private TableView<Blog> tableBlogs;

	@FXML
	private TableColumn<Blog, String> titleColumn2;

	@FXML
	private TableColumn<Blog, String> authorColumn2;

	@FXML
	private TableColumn<Blog, String> dateColumn2;

	@FXML
	private TableColumn<Blog, String> tagColumn2;

	@FXML
	private Button updateButton;

	@FXML
	private TabPane tpDetail;

	@FXML
	private Tab tweetsTab;

	@FXML
	private Tab blogsTab;

	private ObservableList<NFT> nftsList;
	private ObservableList<Tweet> tweetList;
	private ObservableList<Blog> blogList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		titleColumn.setCellValueFactory(new PropertyValueFactory<NFT, String>("title"));
		tagColumn.setCellValueFactory(new PropertyValueFactory<NFT, String>("tag"));
		ArrayList<String> tagStrings = new ArrayList<String>();
		tagStrings.add("anime");
		tagStrings.add("nfts anime");
		nftsList = FXCollections.observableArrayList(new NFT("Art", "Holland", "11/11/2023", tagStrings),
				new NFT("Animate", "Tom", "13/11/2023", tagStrings));
		tableNFTs.setItems(nftsList);

		FilteredList<NFT> filteredData3 = new FilteredList<>(nftsList, b -> true);
		keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData3.setPredicate(NFT -> {
				if (newValue == null) {
					return true;
				}

				String searchKeyword = newValue.toLowerCase();

				if (NFT.getTitle().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				} else if (NFT.getAuthor().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				} else if (NFT.getDate().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				} else
					return false;
			});
		});
		SortedList<NFT> sortedData3 = new SortedList<>(filteredData3);
		sortedData3.comparatorProperty().bind(tableNFTs.comparatorProperty());
		tableNFTs.setItems(sortedData3);

		updateButton = new Button("Update");
		updateButton.setOnAction(event -> {
			// Cập nhật dữ liệu bảng hashtag
			tableNFTs.refresh();
			tableNFTs.setItems(nftsList);
		});

		titleColumn1.setCellValueFactory(new PropertyValueFactory<Tweet, String>("title"));
		authorColumn1.setCellValueFactory(new PropertyValueFactory<Tweet, String>("author"));
		dateColumn1.setCellValueFactory(new PropertyValueFactory<Tweet, String>("date"));
		tagColumn1.setCellValueFactory(new PropertyValueFactory<Tweet, String>("tag"));
		tweetList = FXCollections.observableArrayList(
				new Tweet("Art", "Holland", "11/11/2023", tagStrings, 100, 100, 100),
				new Tweet("Art", "Tom", "12/11/2023", tagStrings, 200, 200, 200),
				new Tweet("Animate", "Tom", "13/11/2023", tagStrings, 150, 150, 150));
		titleColumn2.setCellValueFactory(new PropertyValueFactory<Blog, String>("title"));
		authorColumn2.setCellValueFactory(new PropertyValueFactory<Blog, String>("author"));
		dateColumn2.setCellValueFactory(new PropertyValueFactory<Blog, String>("date"));
		tagColumn2.setCellValueFactory(new PropertyValueFactory<Blog, String>("tag"));
		blogList = FXCollections.observableArrayList(new Blog("Art", "Holland", "11/11/2023", tagStrings, 100),
				new Blog("Art", "Tom", "12/11/2023", tagStrings, 100),
				new Blog("Animate", "Tom", "13/11/2023", tagStrings, 100),
				new Blog("Art", "Holland", "11/11/2023", tagStrings, 100),
				new Blog("Art", "Tom", "12/11/2023", tagStrings, 100),
				new Blog("Animate", "Tom", "13/11/2023", tagStrings, 100));
//		tableTweets.setItems(tweetList);
//		tableBlogs.setItems(blogList);

		FilteredList<Tweet> filteredData1 = new FilteredList<>(tweetList);
//		tableTweets.setItems(filteredData1);

		FilteredList<Blog> filteredData2 = new FilteredList<>(blogList);
//		tableBlogs.setItems(filteredData2);

		tableNFTs.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			tableTweets.setItems(filteredData1);
			tableBlogs.setItems(filteredData2);
			if (newSelection != null) {
				String selectedName = newSelection.getTitle();
				filteredData1
						.setPredicate(tweet -> tweet.getTitle().toLowerCase().contains(selectedName.toLowerCase()));
				filteredData2.setPredicate(blog -> blog.getTitle().toLowerCase().contains(selectedName.toLowerCase()));
			}
		});

	}
}
