import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JFXTest1 extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello world");
		Button bin = new Button("Test2");
		// bin.setText("Say hello!");
		bin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello world!");
			}
		});

		TextField tf = new TextField("Test");

		FlowPane root = new FlowPane();
		//StackPane root = new StackPane();
		root.getChildren().add(bin);
		root.getChildren().add(tf);
		primaryStage.setScene(new Scene(root, 640, 480));
		primaryStage.show();
	}
}
