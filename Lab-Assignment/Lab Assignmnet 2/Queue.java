import java.util.Scanner;

public class Queue{
    static Scanner sc = new Scanner(System.in);
    static int[] queue = new int[10];
    static int front = -1;
    static int rear = -1;

    //isFull()
    static boolean isFull()

    {
        if((front == 0 && rear == queue.length-1) || (front == rear + 1))
        {
            return true;
        } 
        else
        {
            return false;
        }
    }

    //printRearFront()
    static void printRearFront()
    {
        System.out.println("The Rear is: " + rear );
        System.out.println("The Front is :" + front);
    }

    //InsertionAtRear()
    static void InsertionAtRear(int x)
    {
        if(isFull())
        {
            System.out.println("Queue is full!");
            return;
        } 
        else
        {
            if(rear == queue.length-1)
            {
                rear = 0;
                queue[rear] = x;
                System.out.println("Element"  + x + " is inserted");

            } 

            else
            {
                rear++;
                queue[rear] = x;
                System.out.println("Element"  + x + " is inserted");
            } 
            if(front<0)
            { 
                front = 0;
            } 
        } 
       /* System.out.println("The Front is: " + front);
        System.out.println("The rear is: " + rear); */
        System.out.println();
        printRearFront();
    } 

    //isEmpty()
    static boolean isEmpty()
    {
        if(front < 0)
        {
            return true;
        } 
        else
        {
            return false;
        }
    } 

    //DeletionFromFront()
    static void DeleteFromFront()
    {
        int x = 0;
        if(isEmpty())
        {
            System.out.println("The queue is empty!");
            return;
        } 
      else
      {
        if(front == rear)
        {
            x = queue[front];
            System.out.println("Element" + x + " is deleted");
            rear = -1;
            front = -1;
            
        } 
        else
        {
            if(front == queue.length-1)
            {
                x = queue[front];
                System.out.println("Element" + x + " is deleted");
                front = 0;
            } 
            else
            {
                x = queue[front];
                System.out.println("Element" + x + " is deleted");
                front++;
            }
        }
      } 
     /*
      System.out.println("The Front is: " + front);
      System.out.println("The Rear is: " + rear); */
      System.out.println("\n");
      printRearFront();
    }

    //InsertionAtFront()
    static void InsertionAtFront(int x)
    {
        if(isFull())
        {
            System.out.println("Queue is full!");
            return;
        } 
        else
        {
            if(front<0)
            {
                front = 0 ;
                rear = 0;
                queue[front] = x;
                System.out.println("Element " + x + " is inserted");
            } 
            else
            {
             if(front == 0) 
                {
                    front = queue.length -1;
                    queue[front] = x;
                    System.out.println("Element " + x + " is inserted");

                }    
                else
                {
                    front --;
                    queue[front] = x;
                    System.out.println("Element " + x + " is inserted");
                }
            }
        } 
       /*
        System.out.println("The Front is: " + front);
        System.out.println("The Rear is: " + rear);
        */
       System.out.println("\n");
       printRearFront();

    } 
    //DeletionFromRear
    static void DeletionFromRear()
    {
        int x = 0;
        if(isEmpty())
        {
            System.out.println("The queue is empty!");
            return;
        } 
        else
        {
            if(front == rear)
            {
                x = queue[rear];
                System.out.println("Element" + x + " is deleted");
                front = -1;
                rear = -1;
            } 
            else
            {
                if(rear == 0)
                {
                    x = queue[rear];
                    System.out.println("Element" + x + " is deleted");
                    rear = queue.length -1;
                } 
                else
                {
                    x = queue[rear];
                    System.out.println("Element" + x + " is deleted");
                    rear -- ;
                }
            }
        }
      /*   System.err.println("The Front is: " + front);
        System.out.println("The Rear is: " + rear);*/
        System.out.println();
        printRearFront();
    }

    //DislayQueue()
    static void DisplayQueue()
    {   
        if(isEmpty())
        {
            System.out.println("The Queue is empty");
            return;
        } 
        else
        {  
            int temp = front;
            while(true)
            {
            System.out.print(queue[temp] + ",");
            if(temp == rear)
            {
                break;
            }
            if(temp == queue.length-1)
            {
                temp = 0;
            } 
            else
            {
                temp++;
            }
            }
        }
        System.out.println();
    }
public static void main(String[] args) {
   int choice = 0;
    do{
        System.out.println(" ............. QUEUE MENU ..............\n");
        System.out.println("1.Insertion at Front");
        System.out.println("2.Deletion From Rear");
        System.out.println("3.Insertion at Rear");
        System.out.println("4.Deletion from Front ");
        System.out.println("5.Display");
        System.out.println("6.Exit");
        //INPUT CHOICE
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        //switch
        switch (choice) {
            case 1:
                 System.out.print("Enter your data: ");
                 int data = sc.nextInt();
                 InsertionAtFront(data);
                 System.out.println("\n***** Current Queue ******");
                 DisplayQueue();
                 break;

            case 2:
                 DeletionFromRear();
                 DisplayQueue();
                 break;

            case 3:
                 System.out.print("Enter your data: ");
                 data = sc.nextInt();
                 InsertionAtRear(data);
                 System.out.println("\n***** Current Queue ******");
                 DisplayQueue();
                 break;

            case 4:
                 DeleteFromFront();
                 System.out.println("\n***** Current Queue ******");
                 DisplayQueue();
                 break;

            case 5:
                 System.out.println("\n***** Current Queue ******");
                 DisplayQueue();
                break;

            case 6:
                  System.out.println("Exiting the Menu");
                  break;

            default:
                System.out.println("Invalid choice! ");
            break;
        }

    }while(choice!=6);

}

}