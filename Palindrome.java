import java.util.Scanner;

public class Palindrome {
    static Scanner sc = new Scanner(System.in);
    static int top = -1;
    static char [] stack ;
    // Push Method
    static void push(char x)
    {
        if(top==stack.length-1)
        {
            System.out.println("Stack overflow!");
            return;
        }
        else
        {
            top++;
            stack[top] = x;
        }
    } 
    // Pop Method
    static char pop()
    {
        if(top == -1)
        {
            System.out.println("Stack is Empty!");
            return '\0' ;
        } 
        else
        {
            char ch = stack[top];
            top --;
            return ch;
        } 
        
    }
    public static void main(String[] args) {
        // Getting Input
        System.out.println("Enter a String: ");
        String data = sc.nextLine();
        stack = new char[data.length()];

        // Pushing staring as char into stack
        for(int i = 0 ;i< data.length();i++)
        {
            push(data.charAt(i));
        } 
        String reverse = "";
       while(top!=-1)
       {
        
        reverse = reverse +  pop();}
        if(data.equals(reverse))
        {
            System.out.println("The String is a Palindrome!");
            return;
        } 
        else{
            System.out.println("The String is not a palindrome!");
        }
       
    }
}
