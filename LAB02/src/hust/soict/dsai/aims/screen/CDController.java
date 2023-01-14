package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.Aims.AimsMain;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CDController extends OptionBase {
	Stage stage;

	CDController(Stage stage) {
		super(stage);
	}

	@FXML
	private TextField category;

	@FXML
	private TextField cost;

	@FXML
	private TextField title;

	@FXML
	private VBox trackVbox;

	@FXML
	void addCDToStoreBtn(ActionEvent event) {
		List<Track> tracks = new ArrayList<Track>();
		CompactDisc cd;
		// get HBox of track and content
		// if type in class is number but in textfield is string. No accept
		try {
			for (Node node : trackVbox.getChildren()) {
				if (node instanceof HBox) {
					HBox hbox = (HBox) node;
					String titleOfTrack = null;
					int lenOfTrack = 0;
					// get node is children of HBox
					for (Node nd : hbox.getChildren()) {
						if (nd.getTypeSelector().equals("TextField")) {
							// get content
							if (titleOfTrack == null)
								titleOfTrack = ((TextField) nd).getText();
							else
								lenOfTrack = Integer.parseInt(((TextField) nd).getText());
						}
					}
					tracks.add(new Track(titleOfTrack, lenOfTrack));

				}
			}

			// get title,cat,cost of CD and create cd
			cd = new CompactDisc(title.getText(), category.getText(), Float.parseFloat(cost.getText()), "a", 2, "a",
					tracks);
			AimsMain.store.addMedia(cd);

		} catch (Exception e) {

		}

	}

}
