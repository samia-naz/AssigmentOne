import java.util.Scanner;
public class Binary {
static int[] stack = new int[5];
static int top = -1;
static void push(int x ){
    //if(top>=4){
       // System.out.println("Stack overflow");
      //  return;
  //  }
   // else {
       top ++;
       stack[top] = x;
       // System.out.print( stack[x]);
    //}
} 
static void pop(){ 
    if(top == -1)
    {
        System.out.println("Stack is empty!");
        return;
    } 
    else
    {
        while (top>=0) {
            System.out.print(stack[top]);
            top--;
        }
    }
}

public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
    System.out.print("Enter the data: ");
    int data = sc.nextInt();
    while(data>0){
        push(data%2);
        
        data = data/2;
      
    } 
      pop();    

   
}
    
}