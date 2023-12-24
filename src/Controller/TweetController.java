package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import GetDataFromJson.getTweet;
import Modal.Tweet;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TweetController implements Initializable {
	@FXML
	private AnchorPane Anchorlayout;

	@FXML
	private TextField searchText;

	@FXML
	private Text text1;

	@FXML
	private Text heading;

	@FXML
	private TableView<Tweet> tableView;

	@FXML
	private TableColumn<Tweet, String> likeColumn;

	@FXML
	private TableColumn<Tweet, String> replyColumn;

	@FXML
	private TableColumn<Tweet, String> repostColumn;

	@FXML
	private TableColumn<Tweet, String> authorColumn;

	@FXML
	private TableColumn<Tweet, String> dateColumn;

	@FXML
	private TableColumn<Tweet, ArrayList<String>> hashtagColumn;

	@FXML
	private TableColumn<Tweet, String> viewColumn;

	ObservableList<Tweet> tweets = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		replyColumn.setCellValueFactory(new PropertyValueFactory<>("replies"));
		repostColumn.setCellValueFactory(new PropertyValueFactory<>("reposts"));
		likeColumn.setCellValueFactory(new PropertyValueFactory<>("likes"));
		viewColumn.setCellValueFactory(new PropertyValueFactory<>("views"));
		hashtagColumn.setCellValueFactory(new PropertyValueFactory<>("tag"));
		getTweet dataTweet = new getTweet();
		ObservableList<Tweet> dataList = FXCollections.observableArrayList(dataTweet.getArrayList());
		tableView.setItems(dataList);

		// Filter
		FilteredList<Tweet> filteredList = new FilteredList<Tweet>(dataList, b -> true);

		searchText.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredList.setPredicate(Tweet -> {
				String searchKeyWord = newValue.toLowerCase();
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

		// Display text when click in the table view
		tableView.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() == 1) {
				Tweet selectedItem = tableView.getSelectionModel().getSelectedItem();
				if (selectedItem != null) {
					text1.setText(selectedItem.getText());
				}
			}
		});
	}

}
