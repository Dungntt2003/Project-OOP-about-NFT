package Interface;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Data.NFT;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//import javafx.scene.text.Text;

public class RelationController implements Initializable {

	@FXML
	private TableView<NFT> table;

	@FXML
	private TableColumn<NFT, String> titleColumn;

	@FXML
	private TableColumn<NFT, String> authorColumn;

	@FXML
	private TableColumn<NFT, String> dateColumn;

	@FXML
	private TableColumn<NFT, String> tagColumn;

	@FXML
	private Button updateButton;

	private ObservableList<NFT> nftsList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ArrayList<String> tagStrings = new ArrayList<String>();
		tagStrings.add("anime");
		nftsList = FXCollections.observableArrayList(new NFT("Art", "Holland", "11/11/2003", tagStrings));
		titleColumn.setCellValueFactory(new PropertyValueFactory<NFT, String>("title"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<NFT, String>("author"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<NFT, String>("date"));
		tagColumn.setCellValueFactory(new PropertyValueFactory<NFT, String>("tag"));
		table.setItems(nftsList);

		updateButton = new Button("Update");
		updateButton.setOnAction(event -> {
			// Cập nhật dữ liệu bảng hashtag
			table.setItems(nftsList);
		});
	}

}
