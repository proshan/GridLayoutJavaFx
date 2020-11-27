package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window = primaryStage;
        window.setTitle("Grouping Pane");


        //The grid layout is as follows:
        /*

        00 | 10  | 20  | ...
        01  | 11  | 21  | ...
        02  | 12 |  22  | ...
        ...

        First Number = column
        Second Number = row
         */

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        //this padding is for the main pane
        grid.setPadding(new Insets(10, 10, 10, 10));

        //this is for the individual cells in grid
        grid.setVgap(10);
        grid.setHgap(10);

        Label heading = new Label("Log-in");
        GridPane.setConstraints(heading, 0, 0);


        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel, 0, 1);

        TextField nameInput = new TextField();
        //setting default value in the namelabel
        nameInput.setText("Somebody");
        GridPane.setConstraints(nameInput, 1, 1);

        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0, 2);

        TextField passInput = new TextField();
        passInput.setPromptText("Password"); // this disappears after clicking in the field.
        GridPane.setConstraints(passInput, 1, 2);

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 3);

        grid.getChildren().addAll(heading, nameLabel, nameInput, passLabel, passInput, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);

        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
