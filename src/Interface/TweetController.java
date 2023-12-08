package Interface;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Data.Tweet;
import Data.getTweet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TweetController implements Initializable{
		@FXML
		private AnchorPane Anchorlayout;
	  	@FXML
	    private TextField searchText;

	    @FXML
	    private TableColumn<Tweet, String> titleColumn;

	    @FXML
	    private Text heading;

	    @FXML
	    private TableColumn<Tweet, String> authorColumn;

	    @FXML
	    private TableView<Tweet> tableView;

	    @FXML
	    private TableColumn<Tweet, ArrayList<String>> tagColumn;

	    @FXML
	    private TableColumn<Tweet, Integer> likeColumn;

	    @FXML
	    private TableColumn<Tweet, String> dateColumn;
	    ObservableList<Tweet> tweets = FXCollections.observableArrayList();
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
			authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
			dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
			tagColumn.setCellValueFactory(new PropertyValueFactory<>("tag"));
			likeColumn.setCellValueFactory(new PropertyValueFactory<>("like"));
//			shareColumn.setCellValueFactory(new PropertyValueFactory<>("share"));
//			commentColumn.setCellValueFactory(new PropertyValueFactory<>("comment"));
//			ArrayList<String> tag = new ArrayList<String>();
//			tag.add("NFT");
//			tag.add("nfts");
//			ArrayList<Tweet> tweetArrayList = new ArrayList<Tweet>();
//			for (int i = 0 ; i < 100; i++) {
//				tweetArrayList.add(new Tweet("Nftw" + i, "dung", "20/20/2023", tag, 103 + i, 20, 300 ));
//			}
			getTweet dataTweet = new getTweet();
			ObservableList<Tweet> dataList = FXCollections.observableArrayList(dataTweet.getArrayList());
			tableView.setItems(dataList);
			
			// Filter 
			FilteredList<Tweet> filteredList = new FilteredList<Tweet>(dataList, b-> true);
			
			searchText.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredList.setPredicate(Tweet -> {
					if (newValue.isEmpty() || newValue == null) {
						return false;
					}
					String searchKeyWord = newValue.toLowerCase();
					if (Tweet.getTitle().toLowerCase().contains(searchKeyWord))
						return true;
					if (Tweet.getAuthor().toLowerCase().contains(searchKeyWord))
						return true;
					if (Tweet.getDate().contains(searchKeyWord))
						return true;
					if (Tweet.getTag().contains(searchKeyWord))
						return true;
					return false;
				});
				});
			SortedList<Tweet> sortedList = new SortedList<Tweet>(filteredList);
			sortedList.comparatorProperty().bind(tableView.comparatorProperty());
			tableView.setItems(sortedList);
		}
	    
	    
	    
	    
}
