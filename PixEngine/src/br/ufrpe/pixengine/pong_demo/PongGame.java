package br.ufrpe.pixengine.pong_demo;

import br.ufrpe.pixengine.core.GameContainer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class PongGame extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GameContainer gc = new GameContainer(new GameManager(), primaryStage);
        gc.setWidth(640);
        gc.setHeight(480);
        gc.setScale(2);
        gc.setTitle("My Pong!");
        gc.setClearScreen(true);
        gc.setLightEnable(false);
        gc.setDynamicLights(false);
        gc.setLockFrameRate(true);
        gc.start();
        primaryStage.setOnCloseRequest(e -> exitPlatform(primaryStage));
    }
    
    private void exitPlatform(Stage primaryStage) {
        primaryStage.close();
        System.exit(0);
    }
  
    public static void main(String[] args) {
        launch(args);
    }

}
