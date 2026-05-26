import javax.swing.*;
import java.awt.*;

public class RedoUndoGui
{
JFrame frame;
JTextArea text;
JTextField input;
JPanel panel;
JButton insert,delete,redo,undo,display;
// making currentText 
String currentText = "" ;
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
    text.setEditable(false);
    text.setLineWrap(true);
    text.setWrapStyleWord(true);

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
    frame.setLocationRelativeTo(null);
      
    // Adding Actio Listener to Insert Button
    insert.addActionListener(e ->
{
    String newText = input.getText();

    if(!newText.isEmpty())
    {
        UndoPush(currentText); 

        if(currentText.isEmpty())
        {
            currentText = newText;
        }
        else
        {
            currentText = currentText + "\n" + newText;
        }

        text.setText(currentText);
        input.setText("");
        clearRedo(); 
    }
});
   

    
    // Adding action Listener to Display Button 
    display.addActionListener(e ->
        {
            text.setText(currentText);
        }
    );

    // Adding action Listener to Delete Button 
   delete.addActionListener(e ->
{
    if(!currentText.isEmpty())
    {
        UndoPush(currentText);   // purani state save karo

        int lastNewLine = currentText.lastIndexOf("\n");

        if(lastNewLine != -1)
        {
            currentText = currentText.substring(0, lastNewLine);
        }
        else
        {
            currentText = "";
        }

        text.setText(currentText);
        clearRedo();
    }
});

// Adding Action Listener to Undo Button 
undo.addActionListener(e ->
{
    if(undoTop != -1)
    {
        RedoPush(currentText);      
        String previous = UndoPop(); 

        if(previous != null)
        {
            currentText = previous;
            text.setText(currentText);
        }
    }
    else
    {
        System.out.println("Nothing to undo!");
    }
});

// A dding action listener to Redo Button 
redo.addActionListener(e ->
{
    if(redoTop != -1)
    {
        UndoPush(currentText);    
        String nextState = RedoPop(); 

        if(nextState != null)
        {
            currentText = nextState;
            text.setText(currentText);
        }
    }
    else
    {
        System.out.println("Nothing to redo!");
    }
});

    
    } 
    // Definig and Initiliazing stack 
    static String[] undoStack = new String[50];
    static String[] redoStack = new String[50];
    static int undoTop = -1;
    static int redoTop = -1;

    // Adding Helper Method to Undo Stack
    //UndoPush()
    static void UndoPush(String data)
    {
        if(undoTop == undoStack.length - 1)
        {
            System.out.println("Overflow Stack!");
            return ;
        } 
        else
        {
            undoTop++;
            undoStack[undoTop] = data;

        }
         
    } 

    //UndoPop()
    static String UndoPop()
    {
        if(undoTop == -1)
        {
            System.out.println("Stack is empty!");
            return null ;
        } 
        else
        {
            String Undovalue = undoStack[undoTop];
            undoTop--;
            return Undovalue;
        } 
    } 
    //Adding helper methods to Redo Stack 
    //RedoPush()
    static void RedoPush(String data)
    {
        if(redoTop == redoStack.length - 1)
        {
            System.out.println("Stack Overflow!");
            return;

        } 
        else
        {
            redoTop ++ ;
            redoStack[redoTop] = data;

        }
    } 
    //RedoPop()
    static String RedoPop()
    {
        if(redoTop == -1)
        {
            System.out.println("Stack UnderFlow!");
            return null;
        } 
        else
        {
            String redoVal = redoStack[redoTop];
            redoTop -- ;
            return redoVal;
        }
    }
    //ClearRedo()
    static void clearRedo()
    {
        redoTop = -1;
    }

  
public static void main(String[] args) {
    RedoUndoGui obj = new RedoUndoGui();
}
}