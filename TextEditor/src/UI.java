

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;



public class UI extends JPanel implements ActionListener {


    public static JFrame frame = new JFrame("TextEditor");
    private JMenuBar menueLeiste;
    private Handler handler = new Handler();
    private JTextArea textArea;

    public UI() {
        super(new BorderLayout());

        menueLeiste = new JMenuBar();
        addButtons();

        textArea = new JTextArea(5, 30);
        textArea.setEditable(true);

        setPreferredSize(new Dimension(900, 900));
        add(menueLeiste, BorderLayout.PAGE_START);
        add(textArea, BorderLayout.CENTER);


    }

    private void addButtons() {

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open...");
        open.addActionListener( this);
        open.setActionCommand("Open");

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener( this);
        exit.setActionCommand("Exit");

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        save.setActionCommand("Save");

        JMenuItem saveUnder = new JMenuItem("Save...");
        saveUnder.addActionListener(this);
        saveUnder.setActionCommand("Save under");

        JMenuItem about = new JMenuItem("About");
        about.addActionListener(this);
        about.setActionCommand("About");

        JMenuItem undo = new JMenuItem("Undo");
        undo.addActionListener(this);
        undo.setActionCommand("Previous");

        JMenuItem redo = new JMenuItem("Redo");
        redo.addActionListener(this);
        redo.setActionCommand("Next");

        menueLeiste.add(file);
        menueLeiste.add(edit);
        menueLeiste.add(help);

        file.add(open);
        file.add(save);
        file.add(saveUnder);
        file.add(exit);
        edit.add(undo);
        edit.add(redo);
        help.add(about);
    }

    public static void createAndShowGUI() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new UI());
        frame.pack();
        frame.setVisible(true);

    }

    private static void hideGUI() {

        frame.setVisible(false);        //not good

    }

    private static void openAbout(){

        JDialog dialog = new JDialog();

        dialog.setTitle("About this program");
        dialog.setSize(400,600);

        dialog.setVisible(true);
        JLabel aboutLabel = new JLabel("This program was made by \nFelix Schwarz\n as a practice project. ");
        aboutLabel.setHorizontalAlignment(JLabel.CENTER);
        aboutLabel.setVerticalAlignment(JLabel.CENTER);
        dialog.add(aboutLabel);

    }



    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Exit")) {
            hideGUI();

        }
        if (cmd.equals("Open")){


            try {
                textArea.setText("");
                textArea.setText(handler.openFile());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (cmd.equals("Save")){
            handler.saveFile(textArea.getText());
        }
        if (cmd.equals("Save under")){
            handler.saveFileUnder(textArea.getText());
        }

        if (cmd.equals("About")){
            openAbout();
        }

    }

}