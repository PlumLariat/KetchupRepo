package com.example.tictactoe_v3;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LocalOrAIPrompt {

    static Boolean answer;

    public static Boolean display(String title, String msg){
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(msg);

        Button twoPlayer = new Button("Local Two Player Game");
        Button vsAI = new Button("Single Player vs Computer");

        twoPlayer.setOnAction(e -> {
            answer = true;
            window.close();
        });

        vsAI.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,twoPlayer,vsAI);
        layout.setAlignment(Pos.CENTER);

        // Display window and wait
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
