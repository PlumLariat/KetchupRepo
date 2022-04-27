package com.example.tictactoe_v3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DriverController {

    private Parent parent;
    private Scene scene;
    private Stage stage;

    @FXML
    Button localPlayButton = new Button();
    @FXML
    Button onlinePlayButton = new Button();
    @FXML
    Label titleLabel = new Label();

    public void onLocalPlayPressed(ActionEvent event) throws IOException {
        Boolean choice = LocalOrAIPrompt.display("Choose Game Type","Pick a game time to play.");

        if (choice){
            Parent root = FXMLLoader.load(getClass().getResource("TwoPlayerLocalController.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root,600,600);
            stage.setTitle("Tic Tac Toe! (Local)");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else{
            Parent root = FXMLLoader.load(getClass().getResource("PlayerVsAI.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root,600,600);
            stage.setTitle("Tic Tac Toe! (vs computer)");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }

    public void onlinePlayPressed(ActionEvent event) throws Exception {

       Parent root = FXMLLoader.load(getClass().getResource("TicClient.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Tic Tac Toe! (Online)");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
