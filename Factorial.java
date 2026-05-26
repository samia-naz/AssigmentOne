import java.util.Scanner;

public class Factorial {
    static Scanner sc = new Scanner(System.in);
    static int top = -1;
    static int[] stack = new int[5];

    // Push Method
    static void push(int data)
    {
        if(top == stack.length -1)
        {
            System.out.println("Stack Overflow! ");
            return;
        }
        else
        {
            top++;
            stack[top] = data;
        //    System.out.println(stack[top]+ " is pushed");

        }
    } 

    // Pop Method
    static int pop()
    {
        if(top == -1)
        {
            System.out.println("Stack is empty! ");
            return 0;
        }
        else
        {   int finalValue = stack[top];
            //System.out.println(stack[top]);
            top--;
            return finalValue;
        }
    }
    // Factorial Method
    static int factorial(int num)
    {
        int fact = 1;
        for(int i = 1;i<=num;i++)
        {
            fact = fact * i;
        }
        return fact;
    }
    public static void main(String[] args) {
       for(int i = 0 ;i<stack.length;i++)
       {
         System.out.print("Enter you data: ");
         int data = sc.nextInt();
          push(data);
       }
   while (top!=-1) {
    int value = pop();
    if(value!=-1)
{
        System.out.println("The factorial is : " +factorial(value));

}   }       
    }
}
