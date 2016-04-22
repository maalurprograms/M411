package AB_05;

import javax.swing.*;
import java.awt.*;

class Cell extends JButton {
    boolean alive = false;
    int aliveInRange = 0;

    Cell() {
        addActionListener(e -> {
            alive = !alive;
            if (alive){setBackground(Color.YELLOW);}else {setBackground(Color.BLACK);}
        });
    }
}
