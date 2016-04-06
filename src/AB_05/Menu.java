package AB_05;

import javax.swing.*;
import java.awt.*;


public class Menu {

    public static void main(String[] args){
        JFrame jFrame = new JFrame();

        jFrame.setSize(300,100);
        jFrame.setResizable(false);
        jFrame.setLayout(new GridLayout(0,2));
        jFrame.setLocation(java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width/2,java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height/2);

        JLabel updateTimeLabel = new JLabel("Update time (ms):");
        SpinnerModel updateTimeFieldModel = new SpinnerNumberModel(500, 100, 5000, 100);
        JSpinner updateTimeField = new JSpinner(updateTimeFieldModel);

        JLabel fieldSizeLabel = new JLabel("Field size:");
        SpinnerModel fieldSizeFieldModel = new SpinnerNumberModel(10, 10, 100, 1);
        JSpinner fieldSizeField = new JSpinner(fieldSizeFieldModel);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            jFrame.setVisible(false);
            jFrame.dispose();

            int updateTime = (int) updateTimeField.getValue();
            int fieldSize = (int) fieldSizeField.getValue();
            Thread main = new Thread(){
                @Override
                public void run() {
                    new GameOfLife(updateTime, fieldSize);
                }
            };
            main.start();
        });

        jFrame.add(updateTimeLabel);
        jFrame.add(updateTimeField);
        jFrame.add(fieldSizeLabel);
        jFrame.add(fieldSizeField);
        jFrame.add(saveButton);
        jFrame.setVisible(true);

    }
}
