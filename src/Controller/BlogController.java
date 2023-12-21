package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import GetDataFromJson.getBlog;
import Modal.Blog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class BlogController implements Initializable {
	@FXML
	private TableColumn<Blog, Long> viewColumn;

	@FXML
	private TableColumn<Blog, String> titleColumn;

	@FXML
	private TableColumn<Blog, String> authorColumn;

	@FXML
	private TableColumn<Blog, ArrayList<String>> tagColumn;

	@FXML
	private TextField searchWord;

	@FXML
	private TableColumn<Blog, String> dateColumn;

	@FXML
	private TableView<Blog> tableView;

	@FXML
	private Text TextImage1;

	@FXML
	private Text TextImage2;

	@FXML
	private Button button1;

	@FXML
	private Button button2;

	@FXML
	private Button button3;

	@FXML
	private Button button4;

	@FXML
	private Button button5;

	@FXML
	private Text hotTagText;

	ObservableList<Blog> blogs = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		tagColumn.setCellValueFactory(new PropertyValueFactory<>("tag"));
		viewColumn.setCellValueFactory(new PropertyValueFactory<>("view"));
//			JsonParser blog = new JsonParser();
		getBlog data = new getBlog();
		ArrayList<Blog> blogs = data.getArrayList();
		TextImage1.setText(blogs.get(0).getTitle());
		TextImage2.setText(blogs.get(2).getTitle());
		ObservableList<Blog> dataList = FXCollections.observableArrayList(data.getArrayList());
		tableView.setItems(dataList);

		// Filter
		FilteredList<Blog> filteredList = new FilteredList<Blog>(dataList, b -> true);

		searchWord.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredList.setPredicate(Blog -> {
				String searchKeyWord = newValue.toLowerCase();
				if (Blog.getTitle().toLowerCase().contains(searchKeyWord))
					return true;
				if (Blog.getAuthor().toLowerCase().contains(searchKeyWord))
					return true;
				if (Blog.getDate().contains(searchKeyWord))
					return true;
				if (Blog.getTag().contains(searchKeyWord))
					return true;
				return false;
			});
		});
		SortedList<Blog> sortedList = new SortedList<Blog>(filteredList);
		sortedList.comparatorProperty().bind(tableView.comparatorProperty());
		tableView.setItems(sortedList);

		/// tag button
		ArrayList<String> tagList = data.getListTag();
		button1.setText(tagList.get(0));
		button2.setText(tagList.get(1));
		button3.setText(tagList.get(2));
		button4.setText(tagList.get(3));
		button5.setText(tagList.get(4));

		button1.setOnAction(e -> {
			String tagToFilter = button1.getText();
			tableView.setItems(dataList.filtered(blog -> blog.getTag().contains(tagToFilter)));
		});
		button2.setOnAction(e -> {
			String tagToFilter = button2.getText();
			tableView.setItems(dataList.filtered(blog -> blog.getTag().contains(tagToFilter)));
		});
		button3.setOnAction(e -> {
			String tagToFilter = button3.getText();
			tableView.setItems(dataList.filtered(blog -> blog.getTag().contains(tagToFilter)));
		});
		button4.setOnAction(e -> {
			String tagToFilter = button4.getText();
			tableView.setItems(dataList.filtered(blog -> blog.getTag().contains(tagToFilter)));
		});
		button5.setOnAction(e -> {
			String tagToFilter = button5.getText();
			tableView.setItems(dataList.filtered(blog -> blog.getTag().contains(tagToFilter)));
		});

		// hot tag in month
		String top3Tag = "";
		List<String> hotTag = data.getHotTag();
		for (String tag : hotTag) {
			top3Tag += tag + "\n";
		}
		hotTagText.setText(top3Tag);

	}

}
