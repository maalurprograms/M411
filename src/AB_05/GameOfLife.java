package AB_05;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jonas on 31.03.16.
 */
public class GameOfLife {

    public final JButton[][] cells = new CeJButtonll[8][8];
    public final JFrame frame = new JFrame();

    public GameOfLife() {
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(8,8));;
        generateCells(this.cells, frame);

        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void generateCells(JButton[][] cells, JFrame frame){
        int cellID = 1;
        boolean isBomb;
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells.length; y++) {
                isBomb = checkCell(cellID);
                if (isBomb) {
                    cells[x][y] = new Cell(cellID, true, frame);
                } else {
                    cells[x][y] = new Cell(cellID, false, frame);
                }
                cellID += 1;
            }
        }
}
