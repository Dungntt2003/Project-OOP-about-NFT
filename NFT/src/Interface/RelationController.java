package general;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.*;

//import javafx.scene.text.Text;

public class RelationController implements Initializable {
	
	@FXML
	private TableView<NFTs> table;
	
	@FXML
	private TableColumn<NFTs, String> titleColumn;
	
	@FXML
	private TableColumn<NFTs, String> authorColumn;
	
	@FXML
	private TableColumn<NFTs, String> dateColumn;
	
	@FXML
	private TableColumn<NFTs, String> tagColumn;
	
	@FXML
    private Button updateButton;
	
	private ObservableList<NFTs> nftsList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		nftsList = FXCollections.observableArrayList(
				new NFTs("Art", "Holland", "11/11/2023", "[anime, nfts anime, art nfts]")
		);
		titleColumn.setCellValueFactory(new PropertyValueFactory<NFTs, String>("title"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<NFTs, String>("author"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<NFTs, String>("date"));
		tagColumn.setCellValueFactory(new PropertyValueFactory<NFTs, String>("tag"));
		table.setItems(nftsList);
		
		updateButton = new Button("Update");
        updateButton.setOnAction(event -> {
            // Cập nhật dữ liệu bảng hashtag
            table.setItems(nftsList);
        });
	}

}
