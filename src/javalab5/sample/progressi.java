package sample;

// Java program to illustrate the use of Progress Indicator
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class progressi extends Application {

    static double ii = 0;

    // launch the application
    public void start(Stage s) throws Exception
    {
        // set title for the stage
        s.setTitle("creating progressIndicator");

        // create a progress indicator
        final ProgressIndicator pb = new ProgressIndicator();

        // create a tile pane
        TilePane r = new TilePane();

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                // set progress to different level of progressindicator
                ii += 0.1;
                pb.setProgress(ii);
            }

        };

        // creating button
        Button b = new Button("increase");

        // set on action
        b.setOnAction(event);

        // add button
        r.getChildren().add(pb);
        r.getChildren().add(b);

        // create a scene
        Scene sc = new Scene(r, 200, 200);

        // set the scene
        s.setScene(sc);

        s.show();
    }

    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}
