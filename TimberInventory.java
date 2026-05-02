import java.util.Scanner;
 class Timber {
    char zone;
    int timberId;
    String kind;
    float weight;
    String status;
    float height;
    int quantity;
    int price;
    String cutDate;
    Timber next;
    
    // Constructor
    Timber(char zone,
    int timberId,String kind,
    float weight,String status,float height,
    int quantity, int price,String cutDate)
    {
    this.zone = zone;
    this.timberId=timberId;
    this.kind=kind;
    this.weight=weight;
    this.status = status;
    this.height=height;
    this.quantity=quantity;
    this.price=price;
    this.cutDate=cutDate;
    this.next = null;}
    

}

// Main Classs
public class TimberInventory{ 
    static Timber head = null;
     static Scanner sc = new Scanner(System.in);
     
    // ADD TIMBER METHOD
     static void addTimber(){ 
        System.out.print("Enter the zone : ");
        char zone = sc.next().charAt(0);

        System.out.print("Enter the Timber id :");
        int inputId = sc.nextInt();

        // DUPLICATE CHECK
        Timber temp = head;
        //int targetId=0;
        while(temp!=null){ 
            if(temp.timberId == inputId) { 
                System.out.println("This Timber Id already exists :");
                return;
            }
            temp = temp.next ;
        } 
         
        System.out.print("Enter the Timber kind :");
        String kind = sc.next();

        System.out.print("Enter the weight: ");
        float weight = sc.nextFloat();

        System.out.print("Enter the status: ");
        String status = sc.next();

        System.out.print("Enter the height: ");
        float height = sc.nextFloat();

        System.out.print("Enter the Quantity: ");
        int quantity = sc.nextInt();

        
        // Negative check for quantity
        if (quantity <= 0) {           
        System.out.println("Invalid quantity! Quantity must be positive.");
        return;      }              

        System.out.print("Enter the price: ");
        int price = sc.nextInt();

        System.out.print("Enter the cut Date: ");
        String cutDate = sc.next();
         
        // ADDING NEW TIMBER 
        Timber newTimber = new Timber(zone, inputId, kind, weight, status, height, quantity, price, cutDate);
        if(head == null) {
        head = newTimber;    
        } 
     else {
        Timber curr = head ;
        while(curr.next != null){
            curr= curr.next;
        }
        curr.next=newTimber;
     } 
     System.out.println("New Timber Added successfully !"); 
     System.out.println("-----------------");
      }

       // DISPLAY BY ZONE 
     static void displayZone(){ 
        if(head == null) {
            System.out.println("No records Found");
            return;
        } 
        System.out.print("Enter the Zone :");
       char zone = sc.next().charAt(0);
       Timber temp = head;
       boolean found = false;
       while(temp!=null){ 
        if(temp.zone == zone){ 
            System.out.println("Zone:"+temp.zone);
            System.out.println("Kind: "+temp.kind);
            System.out.println("Quantity: "+temp.quantity);
            System.out.println();
            found = true;
        }
        temp = temp.next;
       } 
       if(!found){ 
        System.out.println("No records found for this zone try again !");
        System.out.println("---------------------------");
       } 

     } 
     // DISPLAY BY KIND  
     static void displayKind(){ 
        if(head==null){ 
            System.out.println("No record Found");
            return;
        } 
        System.out.print("Enter the Kind: ");
        String inputKind = sc.next();
        Timber temp = head;
        boolean found = false;
        while(temp!=null){ 
            if(temp.kind.equalsIgnoreCase(inputKind)){ 
                System.out.println("Zone:" +temp.zone);
                System.out.println("Kind:" + temp.kind);
                System.out.println("Quantity:"+temp.quantity);
                System.out.println("Price:"+temp.price);
                found = true;
                break;
            } temp = temp.next;
        } 
        if(!found){ 
            System.out.println("This record does not exist!");
            System.out.println("-----------------------");

        }
     } 
     // ANALYSIS OF RECORD LEVEL
     static void Analysis(){
        if(head==null){ 
            System.out.println("No low stock records found !");
            return;
        } 
        Timber temp = head;
        boolean found = false;
        while(temp!=null){ 
            if(temp.quantity<100){ 
                System.out.println("Zone:" +temp.zone);
                System.out.println("Kind:" +temp.kind);
                System.out.println("Quantity:" +temp.quantity);
                found=true;
                
            } 
            temp = temp.next;
        } 
        if(!found){ 
            System.out.println("This Record does not exist! ");
            System.out.println("----------------------------------");
        }
     }  

     // SALES UPADTE REPORT
     static void salesUpdate(){ 
        if(head==null){ 
            System.out.println("No records Found !");
            return;
        } 
        System.out.print("Enter Timber id: ");
        int tId = sc.nextInt();

        System.out.print("Enter the Quantity: ");
        int inputQuantity = sc.nextInt();

        Timber temp = head;
        boolean found = false;
        while(temp!=null){ 
            if(temp.timberId == tId){ 
                System.out.println("Timber ID found successfully!");
                if(temp.quantity>=inputQuantity){ 
                    temp.quantity= temp.quantity - inputQuantity;
                } 
                else { 
                    System.out.println("Insufficnet Quantity");
                } 
                found = true;
                break;

            } 
           
            temp = temp.next;
        } 
        if(!found){ 
             System.out.println("Timber if not matched!");
             System.out.println("-------------------------------------------");
        }
     }  

     
     // DELETE RECORD
     static void deleteRecord(){ 
        if(head==null){ 
            System.out.println("No Records found!");
            return;
        } 
        //  Delete from beginning
        System.out.println("Enter the Timber ID: ");
        int deleteId = sc.nextInt();
        if(head.timberId == deleteId){ 
            head = head.next;
            System.out.println("Record deleted successfully!");
            return;
        } 
        Timber pre = head;
        Timber curr = head.next;
        boolean found = false;
        while(curr!=null){ 
            if(curr.timberId == deleteId){
                pre.next = curr.next;
                found = true;
                System.out.println("Record Deleted successfully!");
                break;
            } 
            pre = curr;
            curr = curr.next;
        } 
        if(!found){ 
            System.out.println("ID match not found!");
            System.out.println("------------------------------------------");
        }
     }

     // UPDATE RECORD
     static void updateRecord(){ 
        if(head == null){ 
            System.out.println("No Record found! ");
            return;
        } 
        System.out.print("Enter timber Id: ");
        int dltIupdateId = sc.nextInt();
        Timber temp = head;
        boolean found = false;
        while(temp!=null){
            if(temp.timberId == dltIupdateId){ 
                System.out.println("Match Found! ");
                System.out.println("What do you want to Update: ");
                System.out.println("1.Quantity: ");
                System.out.println("2.Price: ");
                System.out.println("3.Status: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Quantity updation:");
                        int newQuantity = sc.nextInt();
                        temp.quantity = newQuantity;
                        System.out.println("Record Updated successfully");
                        break;
                        case 2:
                            System.out.println("Price updation:");
                            int newPrice = sc.nextInt();
                            temp.price = newPrice;
                            System.out.println("Record Updated successfully");

                            break;
                            case 3: 
                            System.out.println("Status updation: ");
                            String newStatus = sc.next();
                            temp.status = newStatus;
                            System.out.println("Record Updated successfully");

                
                    default:
                        System.out.println("Invalid Choice!");
                        break;
                } 
                found = true;
                break;
            } 
            temp = temp.next;
        } 
        if(!found){ 
            System.out.println("Record Not found");
            System.out.println("--------------------------------------------------");
        }
     }  
     

     // INVENTORY REPORT
     static void inventoryReport(){  
        System.out.println("********* INVENTORY REPORT ********");
        if(head == null){ 
            System.out.println("No records found!");
            return;
        } 
        Timber temp = head;
        while(temp!=null){ 
            System.out.println("Id: " +temp.timberId);
            System.out.println("Height:" +temp.height);
            System.out.println("Kind: " + temp.kind);
            System.out.println("Quantity:" +temp.quantity);
            System.out.println("Status: " + temp.status);
            System.out.println("Weight: " + temp.weight);
            System.out.println("Zone: " +temp.zone);
            System.out.println("Price: " +temp.price);
            System.out.println("Cut Date: " + temp.cutDate); 
            temp = temp.next;
        } 
        System.out.println("------ End ------! ");
     }

     // BACKUP AND RESTORE


        

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     // addTimber();
        int choice;
        do{ 
            System.out.println("**** MUHAMMAD UMER TIMBER STORE ****\n");
            System.out.println("1.Add new Timber Records");
            System.out.println("2.Display all records for a given Zone");
            System.out.println("3.Display a particular record given the Kind");
            System.out.println("4.Analysis of record level");
            System.out.println("5.Sales update Report ");
            System.out.println("6.Delete a particular Timber record");
            System.out.println("7.Update a particular Timber record");
            System.out.println("8.Generate Inventory Report");
            System.out.println("9.Backup & Restore Data");
            System.out.println("10.Exit");
            System.out.println("-------------------------------------------");
            // Choice Input
            System.out.print("Enter your choice : ");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    addTimber();
                break;
                case 2:
                    displayZone();
                break;
                case 3:
                    displayKind();
                break;
                case 4:
                    Analysis();
                break;
                case 5:
                    salesUpdate();
                break;
                case 6:
                    deleteRecord();
                break; 
                case 7:
                    updateRecord();
                break;
                case 8:
                    inventoryReport();
                break;
                case 9: 
                System.out.println("9.Backup & Restore Data");
                break;
                case 10:
                System.out.println("10.Exit");
                break;
                default:
                System.out.println("Invalid Choice");
                break;
            }

            
        }while(choice!=10);

    }
}