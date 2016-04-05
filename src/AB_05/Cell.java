package AB_05;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jonas on 31.03.16.
 */
public class Cell extends JButton {
    public boolean alive = false;
    public int aliveInRange = 0;

    public Cell() {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alive = !alive;
                if (alive){setBackground(Color.YELLOW);}else {setBackground(Color.BLACK);}
            }
        });
    }
}
