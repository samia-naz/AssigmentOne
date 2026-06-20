import java.util.Scanner;

public class AirportRunway{
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
            System.out.println(aircraft[temp] + " ");
             
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
    int choice = 0;
    do
    {
        System.out.println(" ***** Aircraft Runway Management *****");
        System.out.println("1.Emeregency Aircraft arrival");
        System.out.println("2.Aircraft departure from front ");
        System.out.println("3.Scheduled aircraft arrival");
        System.out.println("4.Aircraft departure from rear");
        System.out.println("5.Dislay the aircraft queue");
        System.out.println("6.Exit");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter aircraft ID: ");
                String id = sc.next();
                InsertionAtFront(id);
                System.out.println(" ***** The current aircraft queue ****** ");
                Display();
                break;
            case 2:
                DeleteFromFront();
                System.out.println(" ***** The current aircraft queue ****** ");
                Display();
                break;

            case 3:
                System.out.print("Enter aircraft ID: ");
                id = sc.next();
                InsertionAtRear(id);
                System.out.println(" ***** The current aircraft queue ****** ");
                Display();
                break;

            case 4:
                DeletionFromRear();
                System.out.println(" ***** The current aircraft queue ****** ");
                Display();
                break; 
            
            case 5:
                Display();
                break;

            case 6:
                System.out.println("Exitingggg"); 
                break;           
        
            default:
                System.out.println("Invalid Choice!");
                break;
        }
    } while(choice!=6);
}
}