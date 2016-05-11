package AB_05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GameOfLife {

    private Cell[][] cells;
    private int updateTime;

    private int[][] range = new int[][] {{-1, 1}, {0, 1},{1, 1},{-1, 0},{1, -1},{-1, -1},{0, -1},{1, 0}};

    GameOfLife(int updateTime, int fieldSize) {
        this.updateTime = updateTime;
        cells = new Cell[fieldSize][fieldSize];

        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLocation(java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width/2,
                java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height/2);
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

    private void mainLoop(){
        while(true){
            countAlive();
            checkCells();
            try {Thread.sleep(updateTime);}catch (Exception ignored){}
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
        for (Cell[] cell : cells) {
            for (Cell aCell : cell) {
                if (aCell.alive) {
                    if (aCell.aliveInRange < 2 || aCell.aliveInRange > 3) {
                        aCell.alive = false;
                        aCell.setBackground(Color.BLACK);
                    }
                } else {
                    if (aCell.aliveInRange == 3) {
                        aCell.alive = true;
                        aCell.setBackground(Color.YELLOW);
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
