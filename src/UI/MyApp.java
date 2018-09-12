package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import MyDataStructures.*;

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
        panelMain.setPreferredSize(new Dimension(800,500));


        printQueueButton.addActionListener(new ActionListener() {
            /**
             * Prints Queue. Robust enough to handle empty Queues
             *
             * @param e mouse click
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Add File I/O so that printQueue() creates a new file
                //TODO Add penalty period following Exponential backoff algorithm
                System.out.println(Q.printQueue());
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
                if(Q.isEmpty())
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // SwingUtilities.updateComponentTreeUI(frame);
        frame.pack();
        frame.setVisible(true);
    }


}
