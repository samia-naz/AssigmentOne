import java.util.Scanner;

class DNode {
    int data;
    DNode prev;
    DNode next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedListTask {
    static Scanner sc = new Scanner(System.in);

    // Insert at end
    static DNode insertEnd(DNode head, int x) {
        DNode newNode = new DNode(x);

        if (head == null) {
            head = newNode;
        } else {
            DNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        return head;
    }

    // Display list
    static void display(DNode head) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Bubble Sort
    static void sortList(DNode head) {
        if (head == null) {
            return;
        }

        DNode i, j;
        for (i = head; i != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    // Remove Duplicates
    static DNode removeDuplicates(DNode head) {
        if (head == null) {
            return head;
        }

        DNode current = head;
        while (current != null) {
            DNode runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    DNode del = runner;
                    runner = runner.next;

                    if (del.prev != null) {
                        del.prev.next = del.next;
                    }
                    if (del.next != null) {
                        del.next.prev = del.prev;
                    }
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    // Merge Two Sorted Doubly Linked Lists
    static DNode mergeSorted(DNode head1, DNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        DNode dummy = new DNode(0);
        DNode tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1.prev = tail;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2.prev = tail;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        while (head1 != null) {
            tail.next = head1;
            head1.prev = tail;
            tail = tail.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            tail.next = head2;
            head2.prev = tail;
            tail = tail.next;
            head2 = head2.next;
        }

        DNode mergedHead = dummy.next;
        if (mergedHead != null) {
            mergedHead.prev = null;
        }
        return mergedHead;
    }

    // Split List into two halves
    static DNode[] splitList(DNode head) {
        DNode[] halves = new DNode[2];

        if (head == null) {
            halves[0] = null;
            halves[1] = null;
            return halves;
        }

        DNode slow = head;
        DNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        DNode secondHead = slow.next;
        slow.next = null;

        if (secondHead != null) {
            secondHead.prev = null;
        }

        halves[0] = head;
        halves[1] = secondHead;
        return halves;
    }

    public static void main(String[] args) {
        DNode head1 = null;
        DNode head2 = null;

        System.out.print("Enter number of elements for List 1: ");
        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            System.out.print("Enter data for List 1: ");
            int x = sc.nextInt();
            head1 = insertEnd(head1, x);
        }

        System.out.println("Original List 1:");
        display(head1);

        sortList(head1);
        System.out.println("Sorted List 1:");
        display(head1);

        head1 = removeDuplicates(head1);
        System.out.println("List 1 after removing duplicates:");
        display(head1);

        System.out.print("Enter number of elements for List 2: ");
        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
            System.out.print("Enter data for List 2: ");
            int x = sc.nextInt();
            head2 = insertEnd(head2, x);
        }

        System.out.println("Original List 2:");
        display(head2);

        sortList(head2);
        System.out.println("Sorted List 2:");
        display(head2);

        head2 = removeDuplicates(head2);
        System.out.println("List 2 after removing duplicates:");
        display(head2);

        DNode mergedHead = mergeSorted(head1, head2);
        System.out.println("Merged Sorted Doubly Linked List:");
        display(mergedHead);

        DNode[] parts = splitList(mergedHead);
        System.out.println("First Half:");
        display(parts[0]);
        System.out.println("Second Half:");
        display(parts[1]);
    }
}