package Interface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.*;

//import javafx.scene.text.Text;

public class RelationController implements Initializable {
	
	@FXML
	private TableView<NFTs> tableNFTs;
	
	@FXML
	private TableColumn<NFTs, String> titleColumn;
	
	@FXML
	private TableColumn<NFTs, String> authorColumn;
	
	@FXML
	private TableColumn<NFTs, String> dateColumn;
	
	@FXML
	private TableColumn<NFTs, String> tagColumn;
	
	@FXML
	private TableView<Tweet> tableTweets;
	
	@FXML
	private TableColumn<Tweet, String> titleColumn1;
	
	@FXML
	private TableColumn<Tweet, String> authorColumn1;
	
	@FXML
	private TableColumn<Tweet, String> dateColumn1;
	
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
	
	private ObservableList<NFTs> nftsList;
	private ObservableList<Tweet> tweetList;
	private ObservableList<Blog> blogList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		titleColumn.setCellValueFactory(new PropertyValueFactory<NFTs, String>("title"));
		tagColumn.setCellValueFactory(new PropertyValueFactory<NFTs, String>("tag"));
		nftsList = FXCollections.observableArrayList(
				new NFTs("Art", "Holland", "11/11/2023", "[anime, nfts anime, art nfts]"),
				new NFTs("Animate", "Tom", "13/11/2023", "[anime, nfts anime, art nfts]")
		);
		tableNFTs.setItems(nftsList);
		
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
				new Tweet("Art", "Holland", "11/11/2023", "[anime, nfts anime, art nfts]"),
				new Tweet("Art", "Tom", "12/11/2023", "[anime, nfts anime, art nfts]"),
				new Tweet("Animate", "Tom", "13/11/2023", "[anime, nfts anime, art nfts]")
		);
		titleColumn2.setCellValueFactory(new PropertyValueFactory<Blog, String>("title"));
		authorColumn2.setCellValueFactory(new PropertyValueFactory<Blog, String>("author"));
		dateColumn2.setCellValueFactory(new PropertyValueFactory<Blog, String>("date"));
		tagColumn2.setCellValueFactory(new PropertyValueFactory<Blog, String>("tag"));
		blogList = FXCollections.observableArrayList(
				new Blog("Art", "Holland", "11/11/2023", "[anime, nfts anime, art nfts]"),
				new Blog("Art", "Tom", "12/11/2023", "[anime, nfts anime, art nfts]"),
				new Blog("Animate", "Tom", "13/11/2023", "[anime, nfts anime, art nfts]"),
				new Blog("Art", "Holland", "11/11/2023", "[anime, nfts anime, art nfts]"),
				new Blog("Art", "Tom", "12/11/2023", "[anime, nfts anime, art nfts]"),
				new Blog("Animate", "Tom", "13/11/2023", "[anime, nfts anime, art nfts]")
		);
		tableTweets.setItems(tweetList);
		tableBlogs.setItems(blogList);
		
		FilteredList<Tweet> filteredTweets = new FilteredList<>(tweetList, t -> true);
		FilteredList<Blog> filteredBlogs = new FilteredList<>(blogList, b -> true);
		NFTs selected = tableNFTs.getSelectionModel().getSelectedItem();
		if (selected != null) {
			filteredTweets.setPredicate(tweetList -> {
				String lowerCaseFilter = selected.getTitle().toLowerCase();
				if (tweetList.getTitle().toLowerCase() == lowerCaseFilter) {
					return true;
				}
				return false;
			});
			SortedList<Tweet> sortedTweets = new SortedList<>(filteredTweets);
			sortedTweets.comparatorProperty().bind(tableTweets.comparatorProperty());
			tableTweets.setItems(sortedTweets);
			
			filteredBlogs.setPredicate(blogList -> {
				String lowerCaseFilter = selected.getTitle().toLowerCase();
				if (blogList.getTitle().toLowerCase() == lowerCaseFilter) {
					return true;
				}
				return false;
			});
			SortedList<Blog> sortedBlogs = new SortedList<>(filteredBlogs);
			sortedBlogs.comparatorProperty().bind(tableBlogs.comparatorProperty());
			tableBlogs.setItems(sortedBlogs);
		}
	}
}
