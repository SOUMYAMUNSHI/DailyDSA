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
                return get(mid-1);
            }
            if(length % 2 != 0){
                int mid = (length / 2) + 1;
                return get(mid-1);
            }
            return head;
        }
    }

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Middle Node: " + myLinkedList.findMiddleNode().value);

        myLinkedList.append(6);

        System.out.println("===========================");
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Middle Node: " + myLinkedList.findMiddleNode().value);

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

    }
}