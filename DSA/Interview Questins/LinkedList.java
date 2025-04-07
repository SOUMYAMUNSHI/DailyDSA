//Find Middle Node ( ** Interview Question)

public class LinkedList {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // WRITE FIND MIDDLE NODE METHOD HERE //
    // //
    // //
    // //
    // //
    ////////////////////////////////////////

    public Node get(int index) {
        int length = length();
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public int length() {
        Node temp = head;
        if (temp == null) {
            return 0;
        }
        int length = 1;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public Node findMiddleNode() {
        int length = length();
        if (length == 0) {
            return null;
        } else {
            if (length % 2 == 0) {
                int mid = (length / 2) + 1;
                return get(mid - 1);
            }
            if (length % 2 != 0) {
                int mid = (length / 2) + 1;
                return get(mid - 1);
            }
            return head;
        }
    }

    /*
     * @hasLoop()
     * hasLoop() function is based on the algorithm called 'Tortoise and Hare
     * algorithm'
     * where the likedlist is traversed by the two pointers called 'slow' and 'fast'
     * fast moves one node faster than slow.
     * Now, if the loop is present, the 'fast' get inside the loop before the
     * 'slow'. Now inside the circle the head will
     * In each round, the 'fast' moves 1 step closer to the 'slow' inside the loop.
     * 
     * Like two runners on a circular track: faster one will always catch up.
     */
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // It's an intresting code.. DryRun to understand
    public Node findKthFromEnd(int k) {
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /*
     * Given a value x you need to rearrange the linked list such that all nodes
     * with a value less than x come before all nodes with a value greater than or
     * equal to x.
     */
    public void partitionList(int x) {
        if (head == null) {
            return;
        }
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node prev1 = dummy1;
        Node prev2 = dummy2;

        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }

    public static void main(String[] args) {

        // LinkedList myLinkedList = new LinkedList(1);
        // myLinkedList.append(2);
        // myLinkedList.append(3);
        // myLinkedList.append(4);
        // myLinkedList.append(5);

        /* This given code is for findMiddleNode() */

        // System.out.println("1 -> 2 -> 3 -> 4 -> 5");
        // System.out.println("Middle Node: " + myLinkedList.findMiddleNode().value);

        // myLinkedList.append(6);

        // System.out.println("===========================");
        // System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        // System.out.println("Middle Node: " + myLinkedList.findMiddleNode().value);

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * 1 -> 2 -> 3 -> 4 -> 5
         * Middle Node: 3
         * ===========================
         * 1 -> 2 -> 3 -> 4 -> 5 -> 6
         * Middle Node: 4
         * 
         */

        /* This given above code is for findMiddleNode() */

        /* This given code is for hasLoop() */
        // create a loop by connecting the tail to the second node
        // myLinkedList.getTail().next = myLinkedList.getHead().next;

        // System.out.println("Has Loop:");
        // System.out.println(myLinkedList.hasLoop());

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Has Loop:
         * true
         * 
         */

        /* This above code is for hasLoop() */

        /* This code is is for findKthFromEnd() */

        // int k = 2;
        // int result = myLinkedList.findKthFromEnd(k).value;

        // System.out.println(result); // Output: 4

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * 4
         * 
         */

        /* The above code is for findKthFromEnd() */

        /* This bottom code is for Partition List function */
        // Create a new LinkedList and append values to it
        LinkedList ll = new LinkedList(3);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(2);
        ll.append(1);

        // Print the list before partitioning
        System.out.println("LL before partitionList:");
        ll.printList(); // Output: 3 5 8 10 2 1

        // Call the partitionList method with x = 5
        ll.partitionList(5);

        // Print the list after partitioning
        System.out.println("LL after partitionList:");
        ll.printList(); // Output: 3 2 1 5 8 10

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * LL before partition_list:
         * 3
         * 5
         * 8
         * 10
         * 2
         * 1
         * LL after partition_list:
         * 3
         * 2
         * 1
         * 5
         * 8
         * 10
         * 
         */

        /* This above code is for Partition List function */
    }
}