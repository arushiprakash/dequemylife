package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Date;

import MyDataStructures.*;
import jdk.nashorn.internal.scripts.JO;

public class MyApp {
    private JButton printQueueButton;
    private JPanel panelMain;
    private JPanel LargeArea;
    private JButton DequeButton;
    private JButton EnqueButton;
    private JTextArea DequeTextArea;
    private JTextField EnqueTextField;
    private String EnqueDefaultString;
    private Queue Q; // this Queue is of type String


    public MyApp() {
        // set up MyDataStructures.Queue
        Q = new Queue();

        //hello
        panelMain.setPreferredSize(new Dimension(800, 500));


        printQueueButton.addActionListener(new ActionListener() {
            /**
             * Prints Queue. Robust enough to handle empty Queues
             *
             * @param e mouse click
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    MyIO mIO = new MyIO(Q);
                } catch (IOException e1) {
                    System.out.println("Ooops - we tried to print the queue to a file, but failed miserably - you suck!");
                }
                System.out.println(Q.printQueue());
                //TODO Add penalty period following Exponential backoff algorithm

            }
        });
        DequeButton.addActionListener(new ActionListener() {
            /**
             * Dequeue's the first element added to the queue.
             *
             * @param e mouse click
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String ans;
                if (Q.isEmpty())
                    ans = "sorry, the Queue is Empty. Please add to it first :)";
                else
                    ans = Q.dequeue().toString();


                //System.out.println(ans);
                DequeTextArea.setText(ans);
            }
        });


        EnqueButton.addActionListener(new ActionListener() {
            /**
             * Enqueues what was present in the text box to the left the of the button (EnqueueTextField)
             *
             * @param e mouse click on the button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = EnqueTextField.getText();
                Q.enqueue(input, new Date());
                EnqueTextField.setText(EnqueDefaultString);
            }
        });

        panelMain.addComponentListener(new ComponentAdapter() {
            /**
             * Invoked when the component's size changes.
             *
             * @param e Outer frame is resized.
             */
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                SwingUtilities.updateComponentTreeUI(e.getComponent());
            }
        });
        EnqueTextField.addFocusListener(new FocusAdapter() {
            /**
             * Invoked when a component gains the keyboard focus.
             *  Store the default string that was present before user starts overwriting it with their words.
             * @param e key stroke
             */
            @Override
            public void focusGained(FocusEvent e) {
                //super.focusGained(e);
                EnqueDefaultString = EnqueTextField.getText();
            }
        });
    }

    public static void main(String[] args) {
//        System.out.println("My App started");
        JFrame frame = new JFrame("dequemylife");
        frame.setContentPane(new MyApp().panelMain);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // for FULL SCREEN
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new AreYouSure());
    }

    private static class AreYouSure extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            int option = JOptionPane.showOptionDialog(
                    JOptionPane.getRootFrame(),
                    "Would you like to save your Queue?",
                    "Save before Exit", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, null, null);

            if (option == JOptionPane.YES_OPTION) {
                //TODO save queue
                System.exit(0);
            }
        }
    }

}
