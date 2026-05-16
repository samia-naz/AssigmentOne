import javax.swing.*;
import java.awt.*;

public class RedoUndoGui
{
JFrame frame;
JTextArea text;
JTextField input;
JPanel panel;
JButton insert,delete,redo,undo,display;
// Constructor
RedoUndoGui()
{
    //FRAME
    frame = new JFrame("Redo Undo Text Editor");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.setSize(400,300);

    // Input Filed
    input = new JTextField();
    input.setFont(new Font("Arial", Font.PLAIN, 18));
    input.setPreferredSize(new Dimension(100, 40));
    input.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    input.setBackground(new Color(245, 245, 245));

    // BUTTONS
    insert = new JButton("Insert");
    delete = new JButton("Delete");
    redo = new JButton("Redo");
    undo = new JButton("Undo");
    display = new JButton("Display");

    // TEXT AREA
    text = new JTextArea();
    JScrollPane  pane = new JScrollPane(text);

    //BUTTON PANEL
    panel = new JPanel();
    panel.add(insert);
    panel.add(delete);
    panel.add(display);
    panel.add(redo);
    panel.add(undo);

    // Adding Componets to Frame
    frame.add(input,BorderLayout.NORTH);
    frame.add(pane,BorderLayout.CENTER);
    frame.add(panel,BorderLayout.SOUTH);

    //Visibility of Frame
    frame.setVisible(true);

} 
public static void main(String[] args) {
    RedoUndoGui obj = new RedoUndoGui();
}
}