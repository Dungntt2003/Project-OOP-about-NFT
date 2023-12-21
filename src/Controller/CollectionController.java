package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import GetDataFromJson.getCollection;
import Modal.Collection;
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

	@FXML
	private TextField searchword;

	@FXML
	private TableColumn<Collection, String> collectionColumn;

	@FXML
	private TableColumn<Collection, String> volumn;

	@FXML
	private TableColumn<Collection, String> volumnChange;

	@FXML
	private TableView<Collection> tableView;

	@FXML
	private TableColumn<Collection, String> floorPrice;

	@FXML
	private TableColumn<Collection, String> PriceChange;

	@FXML
	private Text Text2;

	@FXML
	private Text Text1;

	ObservableList<Collection> Collections = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		collectionColumn.setCellValueFactory(new PropertyValueFactory<>("collection"));
		volumn.setCellValueFactory(new PropertyValueFactory<>("volumn"));
		volumnChange.setCellValueFactory(new PropertyValueFactory<>("volumn_change"));
		floorPrice.setCellValueFactory(new PropertyValueFactory<>("floor_price"));
		PriceChange.setCellValueFactory(new PropertyValueFactory<>("price_change"));
		getCollection dataCollection = new getCollection();
		Text1.setText(dataCollection.getArrayList().get(0).getCollection());
		Text2.setText(dataCollection.getArrayList().get(1).getCollection());
		ObservableList<Collection> dataList = FXCollections.observableArrayList(dataCollection.getArrayList());
		tableView.setItems(dataList);

		// Filter
		FilteredList<Collection> filteredList = new FilteredList<Collection>(dataList, b -> true);

		searchword.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredList.setPredicate(Collection -> {
				String searchKeyWord = newValue.toLowerCase();
				if (Collection.getCollection().toLowerCase().contains(searchKeyWord))
					return true;
				return false;
			});
		});
		SortedList<Collection> sortedList = new SortedList<Collection>(filteredList);
		sortedList.comparatorProperty().bind(tableView.comparatorProperty());
		tableView.setItems(sortedList);
	}
}
