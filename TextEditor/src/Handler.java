import javax.swing.*;
import java.io.*;

import java.util.Scanner;

public class Handler {


    File currentFile = new File("");

    private void setCurrentFile(File file){
        currentFile = file;
    }
    private File getCurrentFile(){
        return currentFile;
    }

    public void saveFile(String input) {
        try {
            FileWriter myWriter = new FileWriter(currentFile);
            myWriter.write(input);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public String openFile() throws FileNotFoundException {
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            setCurrentFile(file);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("\\Z");

            return (sc.next());

        }
        else return "An error occurred. Unable to open file.";

    }

    public void undoPreviousChange() {


    }

    public void saveFileUnder(String input) {
        try {
            final JFileChooser fc = new JFileChooser();

            int returnVal = fc.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                FileWriter myWriter = new FileWriter(file);
                setCurrentFile(file);
                myWriter.write(input);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
}


}