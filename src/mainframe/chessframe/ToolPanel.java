
package mainframe.chessframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Dimension;
//import mainframe.chessframe.timer.ThreadTimer;

public class ToolPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JTextField turn1TextField = new JTextField(" P2  Turn ");
    private final JTextField turn2TextField = new JTextField(" P1  Turn ");
    private final JTextField whiteTextField = new JTextField("  White ");
    private final JTextField blackTextField = new JTextField("  Black ");
    private final myHistoryList historyList = new myHistoryList();
    //private final short numberOfTurns = 1;
    private final JScrollPane historyScroll = new JScrollPane(historyList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private final JLabel screen1 = new JLabel();
    private final JLabel screen2 = new JLabel();
//    private final JLabel timeDesc1 = new JLabel(" Timer 1");
//    private final JLabel timeDesc2 = new JLabel(" Timer 2");
    //private ThreadTimer timer1;
    //private ThreadTimer timer2;
    private ImageIcon myTurn;
    private String fs;
    private JLabel imageLabelWhite;
    private JLabel checkLabelWhite;
    private JLabel imageLabelBlack;
    private JLabel checkLabelBlack;
    
    /** Creates a new instance of ToolPanel. */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Graphics2D g2 = (Graphics2D)g;

        // draw a rectangle

        /*
         * Ellipse2D start= new Ellipse2D.Double(100, 34, 30, 30); Ellipse2D stop= new
         * Ellipse2D.Double(100, 234, 30, 30); g2.setColor(color.RED.darker());
         * g2.fill(start); g2.setColor(color.GREEN.darker()); g2.fill(stop);
         * 
         * Ellipse2D surr1= new Ellipse2D.Double(100, 34, 30, 30); Ellipse2D surr2= new
         * Ellipse2D.Double(100, 234, 30, 30);
         * 
         * g2.setColor(color.BLACK.brighter());
         * 
         * 
         * g2.draw(surr1); g2.draw(surr2);
         */

    }

    /** initializes ToolPanel to default values.**/
    public ToolPanel() {
        fs = System.getProperty("file.separator");
        myTurn = new ImageIcon("src" + fs + "Icons" + fs
                + "turn.png");
        imageLabelWhite = new JLabel(myTurn);
        imageLabelBlack = new JLabel(myTurn);
        checkLabelWhite = new JLabel(myTurn); //TODO: change to check image
        checkLabelBlack = new JLabel(myTurn);
        
        setMinimumSize(new Dimension(300, 244));
        historyList.setBackground(Color.WHITE);
        setSize(300, 289);
        setLocation(600, 0);
        setLayout(null);

        turn1TextField.setSize(60, 25);
        turn1TextField.setLocation(20, 25);
        screen1.setSize(77, 25);
        screen1.setLocation(92, 25);

        blackTextField.setSize(60, 25);
        blackTextField.setLocation(92, 25);

        turn1TextField.setEnabled(false);
        turn1TextField.setBackground(Color.ORANGE);
        turn1TextField.setDisabledTextColor(Color.BLACK);
        turn1TextField.setFont(new Font("Arial", Font.BOLD, 12));

        blackTextField.setEnabled(false);
        blackTextField.setBackground(new Color(230, 12, 0));
        blackTextField.setFont(new Font("Arial", Font.BOLD, 12));
        blackTextField.setDisabledTextColor(Color.BLACK);

        turn2TextField.setSize(60, 25);
        turn2TextField.setLocation(20, 232);
        screen2.setSize(100, 25);
        screen2.setLocation(90, 254);
        whiteTextField.setSize(60, 25);
        whiteTextField.setLocation(92, 232);

        turn2TextField.setEnabled(false);
        turn2TextField.setBackground(Color.ORANGE);
        turn2TextField.setDisabledTextColor(Color.BLACK);
        turn2TextField.setFont(new Font("Arial", Font.BOLD, 12));

        whiteTextField.setEnabled(false);
        whiteTextField.setBackground(new Color(230, 12, 0));
        whiteTextField.setFont(new Font("Arial", Font.BOLD, 12));
        whiteTextField.setDisabledTextColor(Color.BLACK);

        add(turn1TextField);
        add(blackTextField);
        add(turn2TextField);
        add(whiteTextField);
        add(screen1);
        add(screen2);
        
        
        //default
        imageLabelBlack.setPreferredSize(new Dimension(32, 32));
        imageLabelBlack.setBounds(164, 18, 32, 32);
        imageLabelBlack.setEnabled(false);
        add(imageLabelBlack);
        
        checkLabelBlack.setPreferredSize(new Dimension(32, 32));
        checkLabelBlack.setBounds(208, 18, 32, 32);
        checkLabelBlack.setEnabled(false);
        add(checkLabelBlack);
        
        //white goes first
        imageLabelWhite.setPreferredSize(new Dimension(32, 32));
        imageLabelWhite.setBounds(164, 225, 32, 32);
        imageLabelWhite.setEnabled(true);
        add(imageLabelWhite);
        //imageLabelBlack.setBounds
        
        checkLabelWhite.setPreferredSize(new Dimension(32, 32));
        checkLabelWhite.setBounds(208, 225, 32, 32);
        checkLabelWhite.setEnabled(false);
        add(checkLabelWhite);

        historyScroll.setSize(274, 150);
        historyScroll.setLocation(20, 70);
        add(historyScroll);

    }

    public void setturn() {

    }

    public void add_to_History(Object newItem) {
        historyList.addElemen_tolist(newItem);
    }
    
    public void switchImageLocation(int player) {
        if(player == 1) {
            imageLabelWhite.setEnabled(true);
            imageLabelBlack.setEnabled(false);
        } else {
            imageLabelWhite.setEnabled(false);
            imageLabelBlack.setEnabled(true);
        }
        checkLabelWhite.setEnabled(false);
        checkLabelBlack.setEnabled(false);
        
    }
    
    public void inCheck(int player) {
        if(player == 1) {
            checkLabelWhite.setEnabled(true);
            checkLabelBlack.setEnabled(false);
        } else {
            checkLabelWhite.setEnabled(false);
            checkLabelBlack.setEnabled(true);
        }
    }

//    public void change_to_Timer1() {
//        timer1.resume();
//        timer2.suspend();
//    }
//
//    public void change_to_Timer2() {
//        timer2.resume();
//        timer1.suspend();
//    }
//
//    public void stop_timers() {
//        timer1.stop();
//        timer2.stop();
//    }

    public void startAgain() {
//        if (timer1 != null) {
//            timer1.stop();
//            timer2.stop();
//        }
//
//        timer1 = new ThreadTimer(screen2);
//        timer2 = new ThreadTimer(screen1);
//
//        timer1.start();
//        timer2.start();
//        timer2.suspend();

        historyList.clean_list();
        historyList.addElemen_tolist("Player: New Moves");

    }
}

class myHistoryList extends JList {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    myHistoryList() {

        this.setBackground(Color.ORANGE);
        setModel(listModel);
        listModel.addElement("Player: New Moves");

    }

    public void clean_list() {
        listModel.clear();
    }

    public void addElemen_tolist(Object newItem) {
        listModel.addElement(newItem);
    }

    private DefaultListModel listModel = new DefaultListModel();
}

class myStatusFileds extends JTextField {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    myStatusFileds() {
        this.setEnabled(false);
    }
}
