import java.util.Scanner;

class Node{
    int data;
    Node next ;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
public class StackNode {
    static Scanner sc = new Scanner(System.in);
    static Node top = null;
    // Push Method 
    static void push(int x)
    {
        Node newnode = new Node(x);
        if(top == null)
        {
            top = newnode;
        }
        else
        {
           newnode.next = top;
           top = newnode;
        }
    } 
    // Pop Method
    static int pop()
    {
        if(top ==null)
        {
            System.out.println("Stack is empty! ");
            return 0;
        }
        else
        {
            
           int newdata = top.data;
            top = top.next;
            return newdata;
        }
    }
    // Count Method
    static int count()
    {  int counter = 0;
        Node temp = top;
        while(temp!=null)
        {
            temp= temp.next;
             counter++;
        }
        return counter;

    }

    public static void main(String[] args) {
       while(true)
       {
         System.out.println("Enter your number: ");
        int data = sc.nextInt();
        if(data == -1)
        {
            break;
        }
        push(data);
       }
        int value = pop();
        System.out.println("The " +value + " is popped");
        System.out.println("Total Nodes are: " +count());
    }
}
