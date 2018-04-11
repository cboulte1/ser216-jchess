
package mainframe.chessmenubar.menus.items.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

public class LoadItem extends JMenuItem {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** Creates a new instance of LoadItem. */
    public LoadItem() {
        setText("Load Game");
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadFile.showOpenDialog(null);
            }
        });
    }

    private final JFileChooser loadFile = new JFileChooser();
}
