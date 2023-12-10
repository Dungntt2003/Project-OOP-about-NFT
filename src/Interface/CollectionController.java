package Interface;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Data.Collection;
import Data.getCollection;
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
import javafx.scene.text.Text;

public class CollectionController implements Initializable {
//	 @FXML
//	    private TableColumn<Collection, Integer> transactionColumn;

	@FXML
	private TableColumn<Collection, String> titleColumn;

	@FXML
	private TextField searchword;

	@FXML
	private TableColumn<Collection, String> authorColumn;

	@FXML
	private TableColumn<Collection, ArrayList<String>> tagColumn;

	@FXML
	private TableColumn<Collection, String> dateColumn;

	@FXML
	private TableColumn<Collection, Float> priceColumn;

	@FXML
	private TableView<Collection> tableView;

	@FXML
	private Text Text2;

	@FXML
	private Text Text1;

	ObservableList<Collection> Collections = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		tagColumn.setCellValueFactory(new PropertyValueFactory<>("tag"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//			transactionColumn.setCellValueFactory(new PropertyValueFactory<>("transaction"));
		getCollection dataCollection = new getCollection();
		Text1.setText(dataCollection.getArrayList().get(0).getTitle());
		Text2.setText(dataCollection.getArrayList().get(1).getTitle());
		ObservableList<Collection> dataList = FXCollections.observableArrayList(dataCollection.getArrayList());
		tableView.setItems(dataList);

		// Filter
		FilteredList<Collection> filteredList = new FilteredList<Collection>(dataList, b -> true);

		searchword.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredList.setPredicate(Collection -> {
				if (newValue.isEmpty() || newValue == null) {
					return false;
				}
				String searchKeyWord = newValue.toLowerCase();
				if (Collection.getTitle().toLowerCase().contains(searchKeyWord))
					return true;
				if (Collection.getAuthor().toLowerCase().contains(searchKeyWord))
					return true;
				if (Collection.getDate().contains(searchKeyWord))
					return true;
				if (Collection.getTag().contains(searchKeyWord))
					return true;
				return false;
			});
		});
		SortedList<Collection> sortedList = new SortedList<Collection>(filteredList);
		sortedList.comparatorProperty().bind(tableView.comparatorProperty());
		tableView.setItems(sortedList);
	}
}
