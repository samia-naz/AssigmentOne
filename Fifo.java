import java.util.Scanner;

public class Fifo {
    static Scanner sc = new Scanner(System.in);
    static int top = -1;
    static int [] stack = new int[5];

    // Push Method
    static void push(int x)
    {
        if(top == stack.length-1)
        {
            System.out.println("Stack overflow!");
            return ;

        } 
        else
        {
            top++;
            stack[top] = x;
        } 
        
    }
    // Pop Method
    static void pop()
    {
        if(top == -1)
        {
            System.out.println("Stack is empty!");
            return;
        }
        else
        {
            System.out.println(stack[top]);
            top--;
        }
    } 
    // Display Method
    static void display()
    {
        System.out.println("Your FIFO stack! ");
        if(top == -1)
        {
            System.out.println("Stack is empty!");
            return;
        }
        else
        {
            for(int i =0;i<=top;i++)
            {
                System.out.println("FIFO Elements are: " + stack[i] );
            }
        }
    }
    public static void main(String[] args) {
   for(int i=0;i<stack.length;i++)
   {
    System.out.print("Enter your data: ");
    int data = sc.nextInt();
    push(data);
   } 
   display();
    }
}
