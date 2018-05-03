package test2;


import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
/**
 *
 * @author hazem
 */
public class SudokuGrid extends GridPane{

public static final int GRID_SIZE = 9;

public TextField[][] sudokuCells;
private int[][] solution;
	private int[][] initial;
	private int[][] player;


public SudokuGrid () {
    sudokuCells = new TextField[GRID_SIZE][GRID_SIZE];
    createSudokuGrid();
    for (int row = 0; row < GRID_SIZE; row++) {
        for(int col = 0; col < GRID_SIZE; col++) {
            sudokuCells[row][col] = new TextField() {
                  @Override
                    public void replaceText(int start, int end, String text) {
                      
                        if (text.matches("[1-9]|\\s")) {
                            super.setText(text);
                        }
                    }
                };
            sudokuCells[row][col].setPrefSize(60, 60);
            sudokuCells[row][col].setStyle("-fx-background-color: yellow;");
            add(sudokuCells[row][col], col, row);
           
        }
    }   
    setPrefSize(270, 270); 
    setGridLinesVisible(true);
}

private void createSudokuGrid() {
  
    for (int i = 0; i  < GRID_SIZE; i++) {
        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS) ; 
        rc.setFillHeight(true); 
       
        getRowConstraints().add(rc);

        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS) ; 
        cc.setFillWidth(true); 
        getColumnConstraints().add(cc);
    }

}
public int[][] getPlayer(){
    int [][]player =new int[9][9];
  for (int row = 0; row < GRID_SIZE; row++) {
        for(int col = 0; col < GRID_SIZE; col++) {
        player[row][col]= Integer.parseInt(sudokuCells[row][col].getText());
        
        
        }
  }
return player;
 } 
public void setCells (int[][] player){
 for (int row = 0; row < GRID_SIZE; row++) {
        for(int col = 0; col < GRID_SIZE; col++) {
 sudokuCells[row][col].setText(String.valueOf(player[row][col]));
        
        }
 }

}
}