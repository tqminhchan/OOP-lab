package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims.AimsMain;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartScreenController extends OptionBase {
	private Stage stage;

	@FXML
	private Label totalCost;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediacategory;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private RadioButton radioBtnFilterTitle;

	@FXML
	private TextField tfFilter;

	public CartScreenController(Stage stage) {
		super(stage);
	}

	@FXML
	private void initialize() {

		// get data by cell
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		// push data to table
		tblMedia.setItems(AimsMain.cart.getItemsOrdered(""));
		// init total cost
		setTotalCost();
		// if cast change total will be counted again
		AimsMain.cart.itemsOrdered.addListener(new ListChangeListener<Media>() {
			@Override
			public void onChanged(Change<? extends Media> medias) {
				setTotalCost();
			}

		});

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				if (newValue != null) {
					updateButtonBar(newValue);
				}
			}

		});

		// filter
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {

				if (radioBtnFilterTitle.selectedProperty().getValue() || newValue.equals("")) {
					showFilterMedia(newValue);
				} else {
					// If user find by id but value is string not a number ID will be assigned 0
					int id;
					try {
						id = Integer.parseInt(newValue);
					} catch (Exception e) {
						id = 0;
					}
					showFilterMedia(id);
				}

			}
		});
	}

	// find by title
	void showFilterMedia(String title) {
		tblMedia.setItems(AimsMain.cart.getItemsOrdered(title));
	}

	// find by id
	void showFilterMedia(int id) {
		tblMedia.setItems(AimsMain.cart.getItemsOrdered(id));
	}

	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		AimsMain.cart.removeMedia(media);

	}

	// place order
	@FXML
	void placeOrderBtn(ActionEvent event) {
		AimsMain.cart.setEmtpyCart();
		// set cost
		totalCost.setText(AimsMain.cart.totalCost() + " $");
	}

	// play media
	@FXML
	void playTrackPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		try {
			media.play();
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setContentText(e.getMessage());
			a.show();
		}
	}

	// set total cost
	void setTotalCost() {
		totalCost.setText(AimsMain.cart.totalCost() + " $");
	}

}
