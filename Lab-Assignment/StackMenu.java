import java.util.Scanner;

public class StackMenu {
    static Scanner sc = new Scanner(System.in);
    static int [] stack = new int[5];
    static int top = -1;

    // Adding push Method
    static void push(int data){
        if(top == stack.length -1)
            { 
                System.out.println("Stack overflow! ");
                return;
            } 
            else
              {  top++;
            stack[top] = data;
            System.out.println(" "); }

    } 
    // Adding Pop Method
    static void pop(){
        if(top == -1)
        { 
            System.out.println("Stack is Empty !");
            return;
        } 
        else
        {
            //while(top>=0)
            
                System.out.println(stack[top]+ " is popped");
                top--;

            
        }
    }
    //Adding Display Method
    static void display(){ 
        System.out.println("**** Full Stack ****");
        if(top == -1)
        { 
            System.out.println("Stack is empty !");
            return;
        } 
        else
        {
            for(int i = top;i>=0;i--)
            {
                System.out.println(stack[i]);
            }
        }
    }
public static void main(String[] args) {
    int choice = 0;
    do
    {
        System.out.println("==== STACK MENU ====");
        System.out.println("1. Push ");
        System.out.println("2. Pop ");
        System.out.println("3. Display ");
        System.out.println("4.Exit ");
        // gettting choice
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        // switch statements
        switch (choice) {
            case 1:
                System.out.print("Enter your data: ");
                int data = sc.nextInt();
                push(data);
                break;
            case 2:
                pop();
                break;
            case 3:
                display();
                break;
            case 4:
                System.out.println("Exiting the Menu");
                break;           
            default:
                System.out.println("Invalid choice!");
                break;
        }
    } while(choice != 4);
}    
}
