package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyApp {
    private JButton printQueueButton;
    private JPanel panelMain;
    private JPanel LargeArea;
    private JButton DequeButton;
    private JButton EnqueButton;
    private JTextArea DequeTextArea;
    private JTextField EnqueTextField;

    public MyApp() {
        //hello
        panelMain.setPreferredSize(new Dimension(800,500));


        printQueueButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.out.println("Print Queue button was clicked -> printing the full queue");
                    for (int i = 0; i < 10; i++) {
                        System.out.println("item " +i+ "= blah blah blah" );
                    }
            }
        });
        DequeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("DequeButton clicked!");
            }
        });
        EnqueButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Enque button clicked");
            }
        });

        panelMain.addComponentListener(new ComponentAdapter() {
            /**
             * Invoked when the component's size changes.
             *
             * @param e
             */
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                SwingUtilities.updateComponentTreeUI(e.getComponent());
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("My App started");
        JFrame frame = new JFrame("dequemylife");
        frame.setContentPane(new MyApp().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.updateComponentTreeUI(frame);
        frame.pack();
        frame.setVisible(true);
    }


}
