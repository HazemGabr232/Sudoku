/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author hazem
 */
public class Test2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
     SudokuGrid sudoku =new  SudokuGrid(); 
     Rules rules =new Rules();
     VBox root=new VBox(); 
     root.getChildren().add(sudoku);
     Button init =new Button("Initialize");
     Button solution =new Button("Solution");
     Button check =new Button("Check");
     Label lbl=new Label();
     init.setOnAction(e->{
     sudoku.setCells(rules.getInitial());
         
     });
     solution.setOnAction(e->{
     sudoku.setCells(rules.getSolution());
     });
     check.setOnAction(e->{
     rules.setPlayer(sudoku.getPlayer());
     if (rules.checkForSuccessGeneral())
         lbl.setText("Success");
     else 
        lbl.setText("Failed"); 
     });
     
     root.getChildren().addAll(init,solution,check,lbl);
     
     
     
     
     Scene scene = new Scene(root, 300, 400);
     
        
        primaryStage.setTitle("SUDOKU");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
