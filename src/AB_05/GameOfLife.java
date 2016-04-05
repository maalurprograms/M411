package AB_05;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jonas on 31.03.16.
 */
public class GameOfLife {

    public final Cell[][] cells = new Cell[50][50];
    public final JFrame frame = new JFrame();
    public int[][] range = new int[][] {{-1, 1}, {0, 1},{1, 1},{-1, 0},{1, -1},{-1, -1},{0, -1},{1, 0}};

    public GameOfLife() {
        frame.setSize(1000, 1000);
        frame.setLayout(new GridLayout(cells.length, cells.length));

        generateCells(this.cells, frame);

//        frame.setResizable(false);
        frame.setVisible(true);
    }

    static public void main(String[] args) {
        GameOfLife gameoflife = new GameOfLife();
        while(true){
            gameoflife.countAlive();
            gameoflife.checkCells();
            try {Thread.sleep(500);}catch (Exception e){}
        }
    }

    private void generateCells(Cell[][] cells, JFrame frame) {
        for (int i = 0; i<cells.length;i++) {
            for (int j = 0; j<cells[i].length;j++) {
                cells[i][j] = new Cell();
                if (getRandomBoolean()){
                    cells[i][j].alive = true;
                    cells[i][j].setBackground(Color.YELLOW);
                }else {
                    cells[i][j].alive = false;
                    cells[i][j].setBackground(Color.BLACK);
                }
                frame.add(cells[i][j]);
            }
        }
    }

    private void checkCells(){
        for (int i = 0; i<cells.length;i++) {
            for (int j = 0; j<cells[i].length;j++) {
                if(cells[i][j].alive) {
                    if (cells[i][j].aliveInRange < 2 || cells[i][j].aliveInRange > 3) {
                        cells[i][j].alive = false;
                        cells[i][j].setBackground(Color.BLACK);
                    }
                } else {
                    if (cells[i][j].aliveInRange == 3){
                        cells[i][j].alive = true;
                        cells[i][j].setBackground(Color.YELLOW);
                    }
                }
            }
        }
    }

    private void countAlive(){
        for (int i = 0; i<cells.length;i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].aliveInRange = 0;
                for (int[] point : range) {
                    try {if (cells[i + point[0]][j + point[1]].alive) {
                            cells[i][j].aliveInRange+=1;
                        }
                    } catch (Exception e) {}
                }
            }
        }
    }

    private boolean getRandomBoolean() {
        return Math.random() < 0.5;
        //I tried another approaches here, still the same result
    }
}
