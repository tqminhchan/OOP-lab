package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	private boolean is_pen = true;

	@FXML
	private Pane drawingAreaPane;

	@FXML
	void clearButtonPressed(ActionEvent event) {

		drawingAreaPane.getChildren().clear();
	}

	@FXML
	void drawingOnMouseDragged(MouseEvent event) {
		Circle newCircle = new Circle(event.getX(), event.getY(), 4);
		if (is_pen) {
			drawingAreaPane.getChildren().add(newCircle);
		} else {
			newCircle.setFill(Color.WHITE);
			newCircle.setRadius(8);
			drawingAreaPane.getChildren().add(newCircle);
		}

	}

	@FXML
	void setEraser(ActionEvent event) {
		is_pen = false;
	}

	@FXML
	void setPen(ActionEvent event) {
		is_pen = true;
	}

}
