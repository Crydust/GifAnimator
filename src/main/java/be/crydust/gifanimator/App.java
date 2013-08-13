package be.crydust.gifanimator;

import java.io.IOException;
import java.util.logging.Level;
import javax.swing.UIManager;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String args[]) throws IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        final ImageFrame[] imageFrames = GifReader.readGif(App.class.getResourceAsStream("/examples/Rotating_earth_(large).gif"));

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Gui gui = new Gui(imageFrames);
                // TODO create a viewmodel
                /*
                 gui.jList1.setModel(new javax.swing.AbstractListModel() {
                 String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

                 public int getSize() {
                 return strings.length;
                 }

                 public Object getElementAt(int i) {
                 return strings[i];
                 }
                 });
                 */
                gui.setSize(498, 544);
                gui.setLocationRelativeTo(null);
                gui.setVisible(true);
            }
        });
    }
}
