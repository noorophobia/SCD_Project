package Model;

import javax.swing.*;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.*;

public class WordFileSaver {

    public static void main(String[] args) {
        // Assuming you have a JTextPane named textPane
        JTextPane textPane = new JTextPane();

        // Set the content in your JTextPane
        textPane.setText("This is the content of the Word file.");

        // Save the content to a Word file
        saveToWordFile(textPane, "output.docx");
    }

    public static void saveToWordFile(JTextPane textPane, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            // Set the content from the JTextPane to the Word document
            run.setText(textPane.getText());

            // Save the document
            document.write(fileOutputStream);

            System.out.println("Word file saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
