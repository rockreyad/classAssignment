import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
       //define your offsets here
       private double xOffset = 0;
       private double yOffset = 0;
    @Override
    public void start(Stage primaryStage) {

        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("scenes/MainScene.fxml"));
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            
            //String css = this.getClass().getResource("assets/main.css").toExternalForm();
            //scene.getStylesheets().add(css);

            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    primaryStage.setX(event.getScreenX() - xOffset);
                    primaryStage.setY(event.getScreenY() - yOffset);
                }
            });

            

            Scene scene1 = new Scene(root, Color.TRANSPARENT);
            primaryStage.setScene(scene1);
            primaryStage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);

    }
}