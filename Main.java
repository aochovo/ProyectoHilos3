/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg001proyectohilos;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class Main extends Application{

   public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	Label lb=new Label();
        ProgressBar pb=new ProgressBar();
        Button b=new Button("Contar");
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(lb,b,pb);
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               MiTarea m=new MiTarea();
               Thread hilo=new Thread(m);
               lb.textProperty().bind(m.messageProperty());
               pb.progressProperty().bind(m.progressProperty());
               hilo.setDaemon(true);
               hilo.start();
            }
        });
        Scene s=new Scene(vBox,300,300);
        primaryStage.setScene(s);	
        primaryStage.show();
        }
}
