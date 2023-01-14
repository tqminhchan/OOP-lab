
package hust.soict.dsai.aims.screen;

import java.util.List;

import hust.soict.dsai.aims.Aims.AimsMain;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StoreController extends OptionBase {
	Stage stage;

	@FXML
	private GridPane items;

	StoreController(Stage stage) {
		super(stage);
	}

	@FXML
	private void initialize() {

		AimsMain.store.itemsInStore.addListener(new ListChangeListener<Media>() {
			@Override
			public void onChanged(Change<? extends Media> medias) {

				List<Media> mediaInStore = AimsMain.store.itemsInStore;
				for (int i = 0; i < 9; i++) {
					if (i < AimsMain.store.getItemsInStore().size()) {
						Media media = mediaInStore.get(i);
						VBox vbox = new VBox();
						vbox.setAlignment(Pos.CENTER);
						Label label = new Label(media.getTitle());
						Label label1 = new Label("" + media.getCost());
						vbox.getChildren().add(label);
						vbox.getChildren().add(label1);
						vbox.setSpacing(10);
						vbox.setStyle("-fx-background-color: lightgrey;-fx-border-color: black; "
								+ "-fx-border-width: 2; -fx-border-style: solid;");
						// add button
						HBox hbox = new HBox();
						hbox.setPrefSize(HBox.USE_COMPUTED_SIZE, vbox.getWidth());
						hbox.setAlignment(Pos.CENTER);
						hbox.setSpacing(10);
						Button addToCart = new Button("Add to cast");

						// add Event
						addToCart.setOnAction((ActionEvent event) -> {
							try {
								AimsMain.cart.addMedia(media);
							} catch (Exception e) {
							}
						});

						hbox.getChildren().add(addToCart);
						if (media instanceof Playable) {
							Button playBtn = new Button("Play");
							// add event
							playBtn.setOnAction((ActionEvent event) -> {
								try {
									media.play();
								} catch (Exception e) {
									Alert a = new Alert(AlertType.ERROR);
									a.setContentText(e.getMessage());
									a.show();
								}

							});
							hbox.getChildren().add(playBtn);
						}

						vbox.getChildren().add(hbox);
						// add to girdPane
						items.add(vbox, i % 3, i / 3);

					}

				}
			}

		});

	}

}
