import java.util.Scanner;
public class AirportRunwayQ {
    static Scanner sc = new Scanner(System.in);
    static String[] aircraft = new String[12];
    static int front = -1;
    static int rear = -1;

    //isFull()
    static boolean isFull()
    {
        if((front == 0 && rear == aircraft.length-1) || (front == rear +1))
        {   
            System.out.println("The aircraft is full");
            return true;
        } 
        else
        {
            return false;
        } 
    } 

    //isEmpty()
    static boolean isEmpty()
    {
        if(front<0)
        {  
             System.out.println("The aircraft is empty ");
            return true;
        } 
        else
        {
            return false;
        }
    } 
    //FrontRear()
    static void FrontRear()
    {
        System.out.println("Front is " +front);
        System.out.println("Rear is " +rear);
    }
    
    //                   ====== Emergency aircrafts =====
    //InsertionAtFront()
    static void InsertionAtFront(String data)
    {
        if(isFull())
        {
            return;
        }
        else
        {
            if (front <0) {
                front = 0;
                rear = 0;
                aircraft[front] = data;
            } 
            else
            {
                if(front == 0)
                {
                    front = aircraft.length -1;
                    aircraft[front] = data;
                }
                else
                {
                    front--;
                    aircraft[front] = data;
                }
            }
        } 
        System.out.println("The Aircraft " + data + " is arrived");
        System.out.println();
        FrontRear();
    }
//                    ====== Scheduled Aircrafts =======
// InsertionAtRear()
static void InsertionAtRear(String data)
{
    if(isFull())
    {
        return;
    } 
    else
    {
        if(rear == aircraft.length -1)
        {
            rear = 0;
            aircraft[rear] = data;
        } 
        else
        {
            rear++;
            aircraft[rear] = data;
        } 
        if (front<0) 
        {
            front = 0;
        }
    } 
    System.out.println("The Aircraft " +data+ " is arrived");
    System.out.println();
    FrontRear();
} 
//                    ********* Deletion Processes *********
// DeletionFromFront()
static void DeleteFromFront()
{  String data = "";
    if(isEmpty())
    {
        return;
    } 
    else
    {
        if(front == rear)
        {
            data = aircraft[front];
            front = -1;
            rear = -1;
         }
         else
         {
            if(front == aircraft.length -1)
            {
                data = aircraft[front];
                front = 0;
            } 
            else
            {
                data = aircraft[front];
                front ++;
            }
         }
    } 
    System.out.println("Aircraft " +data+ " is departred");
    System.out.println();
    FrontRear();
}
// DeletionFromRear()
static void DeletionFromRear()
{  String data = "";
    if(isEmpty())
    {
        return;
    } 
    else
    {
        if(front == rear)
        {
            data = aircraft[rear];
            front = -1;
            rear = -1;

        } 
        else
        {
            if(rear == 0)
            {
                data = aircraft[rear];
                rear = aircraft.length-1;
            } 
            else
            {
                data = aircraft[rear];
                rear --;
            }
        }
    }
    System.out.println("Aircraft: " +data + "is departed");
    System.out.println();
    FrontRear();
} 

// Display()
static void Display()
{
    if(isEmpty())
    {
        return;
    } 
    else
    {
        int temp = front;
        while(true)
        {
            System.out.print(aircraft[temp] + " ");
             
            if(temp == rear)
            {
                break;
            } 
            else
            {
                if(temp == aircraft.length -1 )
                {
                    temp = 0;
                } 
                else
                {
                    temp++;
                }
            }
        }
    }
}

public static void main(String[] args) {

    // Initial State
    front = 4;
    rear = 8;

    aircraft[4] = "A1";
    aircraft[5] = "A2";
    aircraft[6] = "A3";
    aircraft[7] = "A4";
    aircraft[8] = "A5";

    System.out.println("===== INITIAL STATE =====");
    FrontRear();
    Display();

    System.out.println("\nInsertFront(E1)");
    InsertionAtFront("E1");
    Display();

    System.out.println("\nInsertRear(S2)");
    InsertionAtRear("S2");
    Display();

    System.out.println("\nDeleteRear()");
    DeletionFromRear();
    Display();

    System.out.println("\nInsertFront(E2)");
    InsertionAtFront("E2");
    Display();

    System.out.println("\nDeleteFront()");
    DeleteFromFront();
    Display();

    System.out.println("\nInsertFront(E3)");
    InsertionAtFront("E3");
    Display();

    System.out.println("\nInsertRear(S1)");
    InsertionAtRear("S1");
    Display();

    System.out.println("\nInsertRear(S3)");
    InsertionAtRear("S3");
    Display();

    System.out.println("\n===== FINAL STATE =====");
    FrontRear();
    Display();
}
}


