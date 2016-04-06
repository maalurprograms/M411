package AB_05;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by jonas on 31.03.16.
 */
public class GameOfLife {

    private Cell[][] cells;
    public int updateTime;

    private JFrame frame = new JFrame();
    private int[][] range = new int[][] {{-1, 1}, {0, 1},{1, 1},{-1, 0},{1, -1},{-1, -1},{0, -1},{1, 0}};

    public GameOfLife(int updateTime, int fieldSize) {
        this.updateTime = updateTime;
        cells = new Cell[fieldSize][fieldSize];

        frame.setSize(1000, 1000);
        frame.setLocation(java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width/2,java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height/2);
        frame.setLayout(new GridLayout(cells.length, cells.length));
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        generateCells(this.cells, frame);
        frame.setVisible(true);

        mainLoop();
    }

    public void mainLoop(){
        while(true){
            countAlive();
            checkCells();
            try {Thread.sleep(updateTime);}catch (Exception e){}
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
    }
}
