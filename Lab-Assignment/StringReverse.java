import java.util.Scanner;

public class StringReverse {
    static Scanner sc = new Scanner(System.in);
    static char[] stack;
    static int top = -1;
    //Adding push function
    static void push(char ch)
    {
        if(top== stack.length-1)
        {
            System.out.println("Stack overflow! ");
            return;
        } 
        else
        {
            top++;
            stack[top] = ch;
        }
    } 
    // Pop Method
    static char pop()
    {
        if(top == -1)
        {
            System.out.println("Stack is empty! ");
            return '\0' ;
        }
        else
        {
             char ch = stack[top];
            top--;
            return ch;
        }
    } 
    // Count Method
    static int count()
    {
        int counter = 0;
        for(int i=0;i<=top;i++)
        {
            counter++;
        }
        return counter;
    }
    public static void main(String[] args) {
        System.out.print("Enter the string: ");
        String data = sc.nextLine();
          stack = new char[data.length()];

        // pushing characters into stack
        for(int i =0;i<data.length();i++)
        {
            push(data.charAt(i));
        } 
        //counting
          System.out.println("There are total " + count() + " in the stack");

        // Reversing the string 
        System.out.println("Reversed String");
        while (top != -1) {
            System.out.print(pop());
        }
    }
}
