import java.util.Scanner;

class CNode {
    int data;
    CNode next;

    CNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SNode {
    int data;
    SNode next;

    SNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedListTask {
    static Scanner sc = new Scanner(System.in);
    static CNode head = null;

    // Display circular list
    static void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        CNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Insert at beginning
    static void insertBeginning(int x) {
        CNode newNode = new CNode(x);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        CNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Insert at end
    static void insertEnd(int x) {
        CNode newNode = new CNode(x);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        CNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Insert at position
    static void insertAtPosition(int x, int pos) {
        if (pos <= 1 || head == null) {
            insertBeginning(x);
            return;
        }

        CNode newNode = new CNode(x);
        CNode temp = head;
        int i = 1;

        while (i < pos - 1 && temp.next != head) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete from beginning
    static void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        CNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        head = head.next;
        temp.next = head;
    }

    // Delete from end
    static void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        CNode temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }

        temp.next = head;
    }

    // Delete by value
    static void deleteByValue(int x) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.data == x) {
            deleteBeginning();
            return;
        }

        CNode temp = head;
        while (temp.next != head && temp.next.data != x) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Value not found!");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Count nodes
    static int countNodes() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        CNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    // Find max and min
    static void findMaxMin() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        int max = head.data;
        int min = head.data;

        CNode temp = head.next;
        while (temp != head) {
            if (temp.data > max) {
                max = temp.data;
            }
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }

        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
    }

    // Check circular nature
    static boolean isCircular() {
        if (head == null) {
            return false;
        }

        CNode temp = head.next;
        while (temp != null && temp != head) {
            temp = temp.next;
        }

        return temp == head;
    }

    // Create singly linked list for conversion
    static SNode insertEndSingly(SNode sHead, int x) {
        SNode newNode = new SNode(x);

        if (sHead == null) {
            sHead = newNode;
        } else {
            SNode temp = sHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        return sHead;
    }

    // Convert singly linked list to circular linked list
    static CNode convertSinglyToCircular(SNode sHead) {
        if (sHead == null) {
            return null;
        }

        CNode cHead = null;
        CNode cTail = null;
        SNode temp = sHead;

        while (temp != null) {
            CNode newNode = new CNode(temp.data);

            if (cHead == null) {
                cHead = newNode;
                cTail = newNode;
            } else {
                cTail.next = newNode;
                cTail = newNode;
            }

            temp = temp.next;
        }

        cTail.next = cHead;
        return cHead;
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==== CIRCULAR LINKED LIST MENU ====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete by Value");
            System.out.println("7. Display");
            System.out.println("8. Count Nodes");
            System.out.println("9. Find Maximum & Minimum");
            System.out.println("10. Check Circular Nature");
            System.out.println("11. Convert Singly LL to Circular LL");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    insertBeginning(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    insertEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    insertAtPosition(data, pos);
                    break;

                case 4:
                    deleteBeginning();
                    break;

                case 5:
                    deleteEnd();
                    break;

                case 6:
                    System.out.print("Enter value to delete: ");
                    deleteByValue(sc.nextInt());
                    break;

                case 7:
                    display();
                    break;

                case 8:
                    System.out.println("Total nodes = " + countNodes());
                    break;

                case 9:
                    findMaxMin();
                    break;

                case 10:
                    if (isCircular()) {
                        System.out.println("List is circular.");
                    } else {
                        System.out.println("List is not circular.");
                    }
                    break;

                case 11:
                    SNode sHead = null;
                    System.out.print("Enter number of nodes in singly list: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter data: ");
                        int x = sc.nextInt();
                        sHead = insertEndSingly(sHead, x);
                    }

                    head = convertSinglyToCircular(sHead);
                    System.out.println("Converted Circular Linked List:");
                    display();
                    break;

                case 12:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 12);
    }
}