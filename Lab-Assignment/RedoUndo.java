import java.util.Scanner;
public class RedoUndo {
    static Scanner sc = new Scanner(System.in);
    static String[] undoStack = new String[60];
    static String[] redoStack = new String[60];
    static int redoTop = -1;
    static int undoTop = -1;
    static String currentText = "";

    // Adding Helper Methods to Undo Stack
    //push()
    static void undoPush(String data)
    {
        if(undoTop == undoStack.length -1)
        {
            System.out.println("Stack overflow!");
            return;
        }
        else
        {
            undoTop++;
            undoStack[undoTop] = data;
        }
    }
    //Pop()
    static String undoPop()
    {
        if(undoTop == -1)
        {
            System.out.println("Stack Underflow! ");
            return null ;
        } 
        else
        {
            String value = undoStack[undoTop];
            undoTop--;
            return value;
        }
    }
    //Adding helper methods to Redo
    //push()
    static void redoPush(String data)
    {
        if(redoTop == redoStack.length -1)
        {
            System.out.println("Stack overflow!");
            return;
        } 
        else
        {
            redoTop++;
            redoStack[redoTop] = data;
        }
    } 
    //pop()
    static String redoPop()
    {
        if(redoTop == -1 )
        {
            System.out.println("Stack Underflow!");
            return null;
        } 
        else
        {
            String value = redoStack[redoTop];
            redoTop--;
            return value;
        }
    }
    // Getting input()
    static void insertText()
    {
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        undoPush(currentText);
        currentText = currentText + text;
        redoTop = -1;
       // System.out.println(currentText);

    } 
    //Undo()
    static void undo()
    {
        if(undoTop == -1)
        {
            System.out.println("Nothing to undo!");
            return;
        } 
        else
        {
            redoPush(currentText);
            String value = undoPop();
            currentText = value;
            System.out.println(currentText);
        }
    }
    //redo()
    static void redo()
    {
        if(redoTop == -1)
        {
            System.out.println("Nothing to Redo!");
            return;
        }
        else
        {
            undoPush(currentText);
            String value = redoPop();
            currentText = value;
            System.out.println(currentText);
        }
    }
    //delete()
    static void delete()
    {
        if(currentText.equals("") )
        {
            System.out.println("Nothing to delete!");
            return;
        } 
      /*  else
        {
            undoPush(currentText);
            int index = currentText.lastIndexOf(" ");
            currentText = currentText.substring(0,index);
        } */
       else
       {
        undoPush(currentText);
        int index = -1;
        for(int i = currentText.length()-1;i>=0;i--)
        {
            if(currentText.charAt(i)== ' ')
               {
                 index = i;
                 break;
               }
        } 
        if(index!=-1)
        {   //substring functions removes something (start,end) start something to include end something to exclude
            currentText = currentText.substring(0,index);
        } 
        else
        {
            currentText = "";
        } 
        redoTop = -1;
        System.out.println(currentText);
       }
    }
    //diplay()
    static void display()
    {
        System.out.println("Current text: " + currentText);
    }
    


    public static void main(String[] args) {
        insertText();
        undo();
        redo();
        delete();
        
    }
    
}
