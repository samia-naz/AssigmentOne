import java.util.Scanner;

class Junction
{
    int junctionId;
    String junctionName;
    Junction left;
    Junction right;

    // Constructor
    Junction(int junctionId,String junctionName)
    {
        this.junctionId = junctionId;
        this.junctionName = junctionName;
        this.left = null;
        this.right = null;
    }

}
public class BST {
    static Scanner sc = new Scanner(System.in);
    static Junction temp ;
    static Junction root = null;
    // insert()
    static void insert()
    {   
        Junction ptr = root;
        System.out.print("Enter junction ID:  ");
        int id = sc.nextInt();

        System.out.print("Enter junction name: ");
        String name = sc.next();
        
        Junction jun = new Junction(id, name);
        if(root ==  null)
        {
            root = jun ;
            return;
        }
        else
        {
            while (ptr != null)
            {
                if (jun.junctionId == ptr.junctionId)
                {
                    System.out.println("This ID already exits!");
                    return;
                }

                temp = ptr;

                if (jun.junctionId < ptr.junctionId)
                {
                    ptr = ptr.left;
                }
                else
                {
                    ptr = ptr.right;
                }
            }

            if (jun.junctionId < temp.junctionId)
            {
                temp.left = jun;
            }
            else
            {
                temp.right = jun;
            }
        }

    } 
    //search()
    static void search()
    {
        System.out.println("Enter your id: ");
        int newid = sc.nextInt();
        Junction ptr = root;
        boolean found = false;
        while(ptr!=null)
        {
            if(newid == ptr.junctionId)
            {
                System.out.println("ID FOUND!");
                found = true;
                break;
            } 
            else
            {
               if(newid < ptr.junctionId)
               {
                ptr = ptr.left;
               } 
               else
               {
                ptr = ptr.right;
               } 
               
            }

        } 
        if(found == false)
        {
        System.out.println(" Id not Found !");
        
        }
    }
    //inOrder()
    static void inOrder(Junction ptr)
    {
        if(ptr!=null)
        {
            inOrder(ptr.left);
            System.out.println(ptr.junctionId);
            System.out.println(ptr.junctionName);
            inOrder(ptr.right);
        }
    }
    // preOrder()
    static void preOrder(Junction ptr)
    {
        if(ptr!=null)
        {
            System.out.println(ptr.junctionId);
            System.out.println(ptr.junctionName);
            preOrder(ptr.left);
            preOrder(ptr.right);
        }
    } 
    //postOrder()
    static void postOrder(Junction ptr)
    {
        if(ptr!=null)
        {
            postOrder(ptr.left);
            postOrder(ptr.right);
            System.out.println(ptr.junctionId);
            System.out.println(ptr.junctionName);
        }
    } 
    // countNodes()
    static int countNodes(Junction ptr)
    {
        int count = 0;
        if(ptr == null)
        {
            
            return 0;
        } 

           int leftCount = countNodes(ptr.left);
            
           int rightCount =  countNodes(ptr.right);
            count = leftCount + rightCount + 1;

       return count;
    }
    
    //heightofBst()
    static int heightofBst(Junction ptr)
    {
        int height = 0;
        if(ptr == null)
        {
            return 0;
        }
        else
        {
            int left = heightofBst(ptr.left);
            int right = heightofBst(ptr.right);
            if(left > right)
            {
                height = left + 1;
            } 
            else
            {
                height = right +1;
            }
        } 
        return height;
    }
    //leafNodes()
    static int leafNodes(Junction ptr)
    {
        if(ptr == null)
        {
            return 0;
        } 
        else
        {
            if(ptr.left == null && ptr.right == null)
            { 
                System.out.print("Junction ID: " + ptr.junctionId);
                System.out.println(" ");
                System.out.print("Junction Name: "+ptr.junctionName);
                return 1;
            }
        } 
        int left = leafNodes(ptr.left);
        int right = leafNodes(ptr.right);
        return left + right;
    } 
    //oneChild()
    static int oneChild(Junction ptr)
    {   int count = 0 ;
        if(ptr == null)
        {
            return 0;
        } 
        else
        {
            if((ptr.left == null && ptr.right!=null) || (ptr.left!=null && ptr.right == null))
            {
                count ++;
            } 

        } 
        int left = oneChild(ptr.left);
        int right = oneChild(ptr.right);
        count = count + left + right;
        return count;
    } 
    //twoChild()
    static int twoChild(Junction ptr)
   {
    int count = 0;
    if(ptr == null)
    {
        return 0;
    } 
    else
    {
        if(ptr.left != null && ptr.right != null)
        {
            count++;
        } 
    } 
    int left = twoChild(ptr.left);
    int right = twoChild(ptr.right);
    count = count + left + right;
    return count;
   } 
   // minimumId()
   static void minimumId()
{
    if(root == null)
    {
        System.out.println("Tree is empty!");
        return;
    }

    Junction ptr = root;

    while(ptr.left != null)
    {
        ptr = ptr.left;
    }

    System.out.println("Minimum Junction ID: " + ptr.junctionId);
}
    //maximumId()
static void maximumId()
{
    if(root == null)
    {
        System.out.println("Tree is empty!");
        return;
    }

    Junction ptr = root;

    while(ptr.right != null)
    {
        ptr = ptr.right;
    }

    System.out.println("Maximum Junction ID: " + ptr.junctionId);
} 

//Depth()
static void depth()
{
    System.out.print("Enter Junction ID: ");
    int id = sc.nextInt();

    Junction ptr = root;
    int depth = 0;

    while(ptr != null)
    {
        if(id == ptr.junctionId)
        {
            System.out.println("Depth = " + depth);
            return;
        }

        if(id < ptr.junctionId)
        {
            ptr = ptr.left;
        }
        else
        {
            ptr = ptr.right;
        }

        depth++;
    }

    System.out.println("Junction not found!");
}
//updateIno()
static void update()
{
    System.out.print("Enter Junction ID to update: ");
    int id = sc.nextInt();

    Junction ptr = root;

    while(ptr != null)
    {
        if(id == ptr.junctionId)
        {
            System.out.print("Enter New Junction Name: ");
            String newName = sc.next();

            ptr.junctionName = newName;

            System.out.println("Updated Successfully!");
            return;
        }

        if(id < ptr.junctionId)
        {
            ptr = ptr.left;
        }
        else
        {
            ptr = ptr.right;
        }
    }

    System.out.println("Junction not found!");
} 
//successor()
static void successor()
{
    System.out.print("Enter Junction ID: ");
    int id = sc.nextInt();

    Junction ptr = root;
    Junction succ = null;

    while(ptr != null)
    {
        if(id < ptr.junctionId)
        {
            succ = ptr;
            ptr = ptr.left;
        }
        else
        {
            ptr = ptr.right;
        }
    }

    if(succ != null)
    {
        System.out.println("Successor ID: " + succ.junctionId);
    }
    else
    {
        System.out.println("No Successor Found!");
    }
}
//Predecessor()
static void predecessor()
{
    System.out.print("Enter Junction ID: ");
    int id = sc.nextInt();

    Junction ptr = root;
    Junction pred = null;

    while(ptr != null)
    {
        if(id > ptr.junctionId)
        {
            pred = ptr;
            ptr = ptr.right;
        }
        else
        {
            ptr = ptr.left;
        }
    }

    if(pred != null)
    {
        System.out.println("Predecessor ID: " + pred.junctionId);
    }
    else
    {
        System.out.println("No Predecessor Found!");
    }
}
//DeleteJunction()
static Junction delete(Junction ptr,int id)
{
    if(ptr == null)
    {
        return null;
    }

    if(id < ptr.junctionId)
    {
        ptr.left = delete(ptr.left,id);
    }
    else if(id > ptr.junctionId)
    {
        ptr.right = delete(ptr.right,id);
    }
    else
    {
        if(ptr.left == null)
        {
            return ptr.right;
        }
        else if(ptr.right == null)
        {
            return ptr.left;
        }

        Junction temp = ptr.right;

        while(temp.left != null)
        {
            temp = temp.left;
        }

        ptr.junctionId = temp.junctionId;
        ptr.junctionName = temp.junctionName;

        ptr.right = delete(ptr.right,temp.junctionId);
    }

    return ptr;
}
//deletecaller()
static void deleteJunction()
{
    System.out.print("Enter Junction ID to delete: ");
    int id = sc.nextInt();

    root = delete(root,id);

    System.out.println("Deletion Completed!");
}

       public static void main(String[] args) {
        int choice = 0;
        do
        {   System.out.println("\n====== JUNCTION MENU ======");
            System.out.println("1.Insert Junction");
            System.out.println("2.Search Junction");
            System.out.println("3.Delete Junction");
            System.out.println("4.Height of BST");
            System.out.println("5.Leaf Nodes");
            System.out.println("6.Total Junctions");
            System.out.println("7.Successor");
            System.out.println("8.One Child Nodes");
            System.out.println("9.Two Children Nodes");
            System.out.println("10.Depth of Junction");
            System.out.println("11.Update Junction");
            System.out.println("12.Traversals");
            System.out.println("13.Minimum ID");
            System.out.println("14.Maximum ID");
            System.out.println("15.Predecessor");
            System.out.println("0 Exit");

            // Choice
            System.out.print("Enter your choice:  ");
            choice = sc.nextInt();
            // switch
           switch (choice)
{
    case 1:
        insert();
        break;

    case 2:
        search();
        break;

    case 3:
        deleteJunction();
        break;

    case 4:
        System.out.println("Height = " + heightofBst(root));
        break;

    case 5:
        System.out.println("Total Leaf Nodes = " + leafNodes(root));
        break;

    case 6:
        System.out.println("Total Junctions = " + countNodes(root));
        break;

    case 7:
        successor();
        break;

    case 8:
        System.out.println("One Child Nodes = " + oneChild(root));
        break;

    case 9:
        System.out.println("Two Child Nodes = " + twoChild(root));
        break;

    case 10:
        depth();
        break;

    case 11:
        update();
        break;

    case 12:

        System.out.println("1. InOrder");
        System.out.println("2. PreOrder");
        System.out.println("3. PostOrder");

        System.out.print("Enter Traversal Choice: ");
        int t = sc.nextInt();

        switch(t)
        {
            case 1:
                inOrder(root);
                break;

            case 2:
                preOrder(root);
                break;

            case 3:
                postOrder(root);
                break;

            default:
                System.out.println("Invalid Traversal Choice!");
        }
        break;

    case 13:
        minimumId();
        break;

    case 14:
        maximumId();
        break;

    case 15:
        predecessor();
        break;


    case 0:
        System.out.println("Program Ended!");
        break;

    default:
        System.out.println("Invalid Choice!");
}

        }while (choice!=0);
        
    }
}
