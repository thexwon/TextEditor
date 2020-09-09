import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {


            public void run() {

                //Turn off metal's use of bold fonts

                UI.createAndShowGUI();
            }
        });

    }
}


